package com.thien.borrowingservice.command.api.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.thien.borrowingservice.command.api.command.DeleteBorrowCommand;
import com.thien.borrowingservice.command.api.event.BorrowCreatedEvent;
import com.thien.borrowingservice.command.api.event.BorrowingUpdateBookReturnEvent;
import com.thien.commonservice.command.UpdateStatusBookCommand;
import com.thien.commonservice.model.BookResponseCommonModel;
import com.thien.commonservice.model.EmployeeResponseCommonModel;
import com.thien.commonservice.query.GetDetailsBookQuery;
import com.thien.commonservice.query.GetDetailsEmployeeQuery;

@Saga
public class BorrowingSaga {
	@Autowired
	private transient CommandGateway commandGateway;

	@Autowired
	private transient QueryGateway queryGateway;

	@StartSaga // được thực hiện sau khi đã hoàn thành quá trình @EventHandler trong
				// BorrowCreatedEvent
	@SagaEventHandler(associationProperty = "id") // @TargetAggregateIdentifier của BorrowCreatedEvent
	private void handle(BorrowCreatedEvent event) {
		System.out.println("==>> BorrowCreatedEvent in Saga for BookId : " + event.getBookId() + " : EmployeeId :  "
				+ event.getEmployeeId());
		try {
			SagaLifecycle.associateWith("bookId", event.getBookId());
			GetDetailsBookQuery getDetailsBookQuery = new GetDetailsBookQuery(event.getBookId());
			GetDetailsEmployeeQuery getDetailsEmployeeQuery = new GetDetailsEmployeeQuery(event.getEmployeeId());
			BookResponseCommonModel bookResponseModel = new BookResponseCommonModel();
			EmployeeResponseCommonModel employeeResponseCommonModel = new EmployeeResponseCommonModel();
			try {
				bookResponseModel = queryGateway
						.query(getDetailsBookQuery, ResponseTypes.instanceOf(BookResponseCommonModel.class)).join();
			} catch (Exception e) {
				System.out.println("Không thể lấy GetDetailsBookQuery");
			}

			try {
				employeeResponseCommonModel = queryGateway
						.query(getDetailsEmployeeQuery, ResponseTypes.instanceOf(EmployeeResponseCommonModel.class))
						.join();
			} catch (Exception e) {
				System.out.println("Không thể lấy GetDetailsEmployeeQuery");
			}

			if (bookResponseModel.getIsReady() == true) {
				if (employeeResponseCommonModel.getIsDisciplined() != true) {
					UpdateStatusBookCommand command = new UpdateStatusBookCommand(event.getBookId(), false,
							event.getEmployeeId(), event.getId());
					commandGateway.sendAndWait(command);
				} else {
					throw new Exception("Người mượn đang bị kỷ luật");
				}
			} else {
				throw new Exception("Sách đã có người mượn");
			}
		} catch (Exception e) {
			rollBackBorrowRecord(event.getId());
			System.out.println(e.getMessage());
		}
	}

	private void rollBackBorrowRecord(String id) {
		commandGateway.sendAndWait(new DeleteBorrowCommand(id));
	}

	@StartSaga
	@SagaEventHandler(associationProperty = "id")
	private void handle(BorrowingUpdateBookReturnEvent event) {
		System.out.println("BorrowingUpdateBookReturnEvent in Saga for borrowing Id : " + event.getId());
		try {
			UpdateStatusBookCommand command = new UpdateStatusBookCommand(event.getBookId(), true,
					event.getEmployeeId(), event.getId());
			commandGateway.sendAndWait(command);
			SagaLifecycle.end();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

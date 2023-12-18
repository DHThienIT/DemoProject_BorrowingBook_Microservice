package com.thien.borrowingservice.command.api.aggregate;

import java.util.Date;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.thien.borrowingservice.command.api.command.CreateBorrowCommand;
import com.thien.borrowingservice.command.api.command.DeleteBorrowCommand;
import com.thien.borrowingservice.command.api.command.UpdateBookReturnCommand;
import com.thien.borrowingservice.command.api.event.BorrowCreatedEvent;
import com.thien.borrowingservice.command.api.event.BorrowDeletedEvent;
import com.thien.borrowingservice.command.api.event.BorrowingUpdateBookReturnEvent;

@Aggregate
public class BorrowAggregate {
	@AggregateIdentifier
	private String id;
	private String bookId;
	private String employeeId;
	private Date borrowingDate;
	private Date returnDate;

	public BorrowAggregate() {
	}

	@CommandHandler
	public BorrowAggregate(CreateBorrowCommand command) {
		BorrowCreatedEvent event = new BorrowCreatedEvent();
		BeanUtils.copyProperties(command, event);
		AggregateLifecycle.apply(event);
	}

	@CommandHandler
	public void handle(DeleteBorrowCommand command) {
		System.out.println("--> 11111111111111111111111111");
		BorrowDeletedEvent event = new BorrowDeletedEvent();
		BeanUtils.copyProperties(command, event);
		AggregateLifecycle.apply(event);
	}
	
	@CommandHandler
	public void handle(UpdateBookReturnCommand command) {
		BorrowingUpdateBookReturnEvent event = new BorrowingUpdateBookReturnEvent();
		BeanUtils.copyProperties(command, event);
		AggregateLifecycle.apply(event);
	}

	@EventSourcingHandler
	public void on(BorrowCreatedEvent event) {
		this.id = event.getId();
		this.bookId = event.getBookId();
		this.employeeId = event.getEmployeeId();
		this.borrowingDate = event.getBorrowingDate();
	}

	@EventSourcingHandler
	public void on(BorrowDeletedEvent event) {
		System.out.println("--> 2222222222222222222222222222");
		this.id = event.getId();
	}
	
	@EventSourcingHandler
	public void on(BorrowingUpdateBookReturnEvent event) {
		this.id = event.getId();
		this.bookId = event.getBookId();
		this.employeeId = event.getEmployeeId();
		this.returnDate = event.getReturnDate();
	}
}

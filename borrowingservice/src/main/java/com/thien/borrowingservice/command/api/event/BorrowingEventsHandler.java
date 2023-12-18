package com.thien.borrowingservice.command.api.event;

import java.util.logging.Logger;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thien.borrowingservice.command.api.data.Borrowing;
import com.thien.borrowingservice.command.api.repository.BorrowRepository;

@Component
public class BorrowingEventsHandler {
	@Autowired
	private BorrowRepository borrowRepository;
	
	private static final Logger LOGGER = Logger.getLogger(BorrowingEventsHandler.class.getName());

	@EventHandler
	public void on(BorrowCreatedEvent event) {
		Borrowing borrowing = new Borrowing();
		BeanUtils.copyProperties(event, borrowing);
		borrowRepository.save(borrowing);
	}

	@EventHandler
	public void on(BorrowingUpdateBookReturnEvent event) {
		try {
			Borrowing borrowing = borrowRepository.findByEmployeeIdAndBookIdAndReturnDateIsNull(event.getEmployeeId(),
					event.getBookId());
			borrowing.setReturnDate(event.getReturnDate());
			borrowRepository.save(borrowing);
		} catch (Exception e) {
			System.out.println("Lỗi không tìm thấy dữ liệu borrowing nào");
		}
	}

	@EventHandler
	public void on(BorrowDeletedEvent event) {
		if (borrowRepository.findById(event.getId()).isPresent()) {
			Borrowing borrowing = borrowRepository.getById(event.getId());
			if (borrowing.getReturnDate() != null) {
				borrowRepository.deleteById(event.getId());
			} else {
				LOGGER.info("==> Sách này chưa được trả");
			}
		} else {
			LOGGER.info("==> Lỗi không tìm thấy dữ liệu borrowing nào");
		}
	}
}

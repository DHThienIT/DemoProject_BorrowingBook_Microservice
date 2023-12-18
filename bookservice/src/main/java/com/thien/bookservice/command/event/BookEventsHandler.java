package com.thien.bookservice.command.event;

import java.util.Optional;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thien.bookservice.command.data.Book;
import com.thien.bookservice.command.repository.BookRepository;
import com.thien.commonservice.event.BookUpdateStatusEvent;

@Component
public class BookEventsHandler {
	@Autowired
	private BookRepository bookRepository;

	@EventHandler
	public void on(BookCreatedEvent event) {
		Book book = new Book();
		BeanUtils.copyProperties(event, book);
		bookRepository.save(book);
	}
	
	@EventHandler
	public void on(BookUpdatedEvent event) {
		Book book = bookRepository.getById(event.getBookId());
		book.setName(event.getName());
		book.setAuthor(event.getAuthor());
		book.setIsReady(event.getIsReady());
		bookRepository.save(book);
	}
	
	@EventHandler
	public void on(BookDeletedEvent event) {
		bookRepository.deleteById(event.getBookId());
	}
	@EventHandler
	public void on(BookUpdateStatusEvent event) {
		Book book = bookRepository.getById(event.getBookId());
		book.setIsReady(event.getIsReady());
		bookRepository.save(book);
	}
}

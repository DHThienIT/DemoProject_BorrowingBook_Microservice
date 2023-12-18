package com.thien.borrowingservice.command.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thien.borrowingservice.command.api.repository.BorrowRepository;

@Service
public class BorrowService {
	@Autowired
	private BorrowRepository repository;

//	public void sendMessage(Message message) {
//		try {
//			ObjectMapper mapper = new ObjectMapper();
//			String json = mapper.writeValueAsString(message);
//			output.send(MessageBuilder.withPayload(json).build());
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public String findIdBorrowing(String employeeId, String bookId) {
		return repository.findByEmployeeIdAndBookIdAndReturnDateIsNull(employeeId, bookId).getId();
	}
}

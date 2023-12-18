package com.thien.employeeservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thien.employeeservice.query.model.EmployeeReponseModel;
import com.thien.employeeservice.query.query.GetAllEmployeeQuery;
import com.thien.employeeservice.query.query.GetEmployeeQuery;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {
	@Autowired
	private QueryGateway queryGateway;

	@GetMapping("/{employeeId}")
	public EmployeeReponseModel getBookEmployee(@PathVariable String employeeId) {
		GetEmployeeQuery getEmployeeQuery = new GetEmployeeQuery();
		getEmployeeQuery.setEmployeeId(employeeId);
		EmployeeReponseModel employeeReponseModel = queryGateway
				.query(getEmployeeQuery, ResponseTypes.instanceOf(EmployeeReponseModel.class)).join();
		return employeeReponseModel;
	}

	@GetMapping("")
	public List<EmployeeReponseModel> getAllEmployee() {
		GetAllEmployeeQuery getAllEmployeeQuery = new GetAllEmployeeQuery();
		List<EmployeeReponseModel> employeeReponseModels = queryGateway
				.query(getAllEmployeeQuery, ResponseTypes.multipleInstancesOf(EmployeeReponseModel.class)).join();
		return employeeReponseModels;
	}
}

package com.thien.employeeservice.command.event;

public class EmployeeUpdateDisciplinedEvent {
	private String employeeId;
	private Boolean isDisciplined;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Boolean getIsDisciplined() {
		return isDisciplined;
	}

	public void setIsDisciplined(Boolean isDisciplined) {
		this.isDisciplined = isDisciplined;
	}
}

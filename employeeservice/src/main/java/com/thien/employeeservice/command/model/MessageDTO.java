package com.thien.employeeservice.command.model;

import java.util.Date;

public class MessageDTO {
	private String toName;
	private String subject;
	private String content;
	private Date createdDate;

	public MessageDTO() {
	}

	public MessageDTO(String toName, String subject, String content, Date createdDate) {
		super();
		this.toName = toName;
		this.subject = subject;
		this.content = content;
		this.createdDate = createdDate;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
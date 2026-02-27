package com.mohre.middleware.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name ="Mohre_Audit_log")
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {
	private Instant audit_time;
	private String username;
	private String action;
	private String description;
	private String source;

}

package com.project.autoparkweb.mvc.model.dao;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String login;
	String password;
}

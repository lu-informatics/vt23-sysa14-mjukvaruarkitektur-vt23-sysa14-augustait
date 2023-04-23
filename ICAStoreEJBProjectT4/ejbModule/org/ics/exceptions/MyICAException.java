package org.ics.exceptions;

import java.sql.SQLException;

public class MyICAException extends Exception{
	
	public MyICAException() {
	}
	public MyICAException(String msg) {
	super(msg);
	}
	 public MyICAException(String message, Throwable cause) {
	        super(message, cause);
	    }

	
	
	}	



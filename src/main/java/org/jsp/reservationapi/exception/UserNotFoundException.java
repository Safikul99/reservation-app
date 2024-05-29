package org.jsp.reservationapi.exception;

public class UserNotFoundException extends RuntimeException {
	private static long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}

}

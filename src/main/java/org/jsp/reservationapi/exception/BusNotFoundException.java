package org.jsp.reservationapi.exception;

public class BusNotFoundException extends RuntimeException
{
	private static long serialVersionUID=1L;
	public BusNotFoundException(String message)
	{
		super(message);
	}

}

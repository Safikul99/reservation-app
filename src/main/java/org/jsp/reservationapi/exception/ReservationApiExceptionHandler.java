package org.jsp.reservationapi.exception;

import org.jsp.reservationapi.dto.ResponceStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ReservationApiExceptionHandler extends  ResponseEntityExceptionHandler
{
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>>handel(AdminNotFoundException exception)
	{
		ResponceStructure<String>structure=new ResponceStructure<>();
		structure.setData("Admin Not Found");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.OK).body(structure);
		
	}
	

}

package org.jsp.reservationapi.exception;

import java.util.HashMap;
import java.util.Map;

import org.jsp.reservationapi.dto.ResponceStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ReservationApiExceptionHandler {
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> handel(AdminNotFoundException exception) {
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setData("Admin Not Found");
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.OK).body(structure);

	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String>handleValidationExceptions(MethodArgumentNotValidException ex)
	{
		Map<String,String>errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String fileName=((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fileName, errorMessage);
			
		});
		return errors;
	}

}

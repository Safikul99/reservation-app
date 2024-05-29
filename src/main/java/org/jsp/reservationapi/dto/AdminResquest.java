package org.jsp.reservationapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminResquest 
{
	
	private long phone;
	@Email(message = "Invalid format")
	private String email;
	@NotBlank(message = "GST number is mandatory")
	@Size(min=15,max=15,message = "GST Number have 15 characther")
	private String gst_number;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotBlank(message = "Travels Name is mandatory")
	private String travles_name;
	@NotBlank(message = "Password is mandatroy")
	@Size(min=8,max=15,message = "password lenhtg must be between 8 to 15")
	private String password;

}

package org.jsp.reservationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private int age;
	@Column(unique =true,nullable = false)
	private long phone;
	@Column(unique =true,nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;

	

}

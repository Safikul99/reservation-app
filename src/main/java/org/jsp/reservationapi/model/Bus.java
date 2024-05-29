package org.jsp.reservationapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bus 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@Column(nullable =false)
	private String bus_name;
	@Column(nullable =false)
	private String date_of_journey;
	@Column(unique = true ,nullable =false)
	private String bus_no;
	@Column(nullable =false)
	private String form_loc;
	@Column(nullable =false)
	private String to_loc;
	@Column(nullable =false)
	private int no_of_seat;
	

}

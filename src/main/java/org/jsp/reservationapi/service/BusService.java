package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.BusDao;
import org.jsp.reservationapi.dto.ResponceStructure;
import org.jsp.reservationapi.exception.UserNotFoundException;
import org.jsp.reservationapi.model.Bus;
import org.jsp.reservationapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService 
{
	@Autowired
	private BusDao busDao;
	
	 public  ResponseEntity<ResponceStructure<Bus>> saveBus(Bus bus)
	{
		ResponceStructure<Bus> structure=new ResponceStructure<>();
		structure.setMessage("Bus saved");
		structure.setData(busDao.savebus(bus));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
		
	}
	 public ResponseEntity<ResponceStructure<Bus>>findById(int id)
		{
			ResponceStructure<Bus>structure=new ResponceStructure<>();
			Optional<Bus> dbBus= busDao.findById(id);
			if(dbBus.isPresent())
			{
				structure.setData(dbBus.get());
				structure.setMessage("Bus Found");
				structure.setStatusCode(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(structure);
			}
			return null;
		}
	 public ResponseEntity<ResponceStructure<String>> delete(int id)
		{
			ResponceStructure<String>structure=new ResponceStructure<>();
			Optional<Bus> dbUser= busDao.findById(id);
			if(dbUser.isPresent())
			{
				busDao.delete(id);
				
				structure.setData("Bus Found");
				structure.setMessage("delete");
				structure.setStatusCode(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(structure);
				
				
			}
			return null;
			
		}
	

}

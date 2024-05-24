package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.AdminDao;
import org.jsp.reservationapi.dto.ResponceStructure;
import org.jsp.reservationapi.exception.AdminNotFoundException;
import org.jsp.reservationapi.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class AdminService 
{
	@Autowired
	private AdminDao adminDao;
	public   ResponseEntity<ResponceStructure<Admin>> saveAdmin(Admin admin)
	{
		ResponceStructure<Admin> structure=new ResponceStructure<>();
		structure.setMessage("Admin saved");
		structure.setData(adminDao.saveAdmin(admin));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
		
	}
	public ResponseEntity<ResponceStructure<Admin>>update(Admin admin)
	{
		Optional<Admin> recAdmin= adminDao.findById(admin.getId());
		ResponceStructure<Admin> structure=new ResponceStructure<>();
		if(recAdmin.isPresent())
		{
			Admin dbAdmin=recAdmin.get();
			dbAdmin.setEmail(admin.getEmail());
			dbAdmin.setName(admin.getName());
			dbAdmin.setGst_number(admin.getGst_number());
			dbAdmin.setPassword(admin.getPassword());
			dbAdmin.setPhone(admin.getPhone());
			dbAdmin.setTravles_name(admin.getTravles_name());
			structure.setData(adminDao.saveAdmin(admin));
			structure.setMessage("Admin Update");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure);
			
		}
		throw new AdminNotFoundException("Cannot Updare Admin as Id is Invalid");
		
	}
	public ResponseEntity<ResponceStructure<Admin>>findById(int id)
	{
		ResponceStructure<Admin>structure=new ResponceStructure<>();
		Optional<Admin> dbAdmin= adminDao.findById(id);
		if(dbAdmin.isPresent())
		{
			structure.setData(dbAdmin.get());
			structure.setMessage("Admin Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new AdminNotFoundException("Invalid Admin Id");
	}
	public ResponseEntity<ResponceStructure<Admin>>verify(long phone,String password)
	{
		ResponceStructure<Admin>structure=new ResponceStructure<>();
		Optional<Admin> dbAdmin= adminDao.verify(phone, password);
		if(dbAdmin.isPresent())
		{
			structure.setData(dbAdmin.get());
			structure.setMessage("verification Success");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
			
			
		}
		throw new AdminNotFoundException("Invalid Phone number or Password");
	}
	public ResponseEntity<ResponceStructure<Admin>>verify(String email,String password)
	{
		ResponceStructure<Admin>structure=new ResponceStructure<>();
		Optional<Admin> dbAdmin= adminDao.verify(email, password);
		if(dbAdmin.isPresent())
		{
			structure.setData(dbAdmin.get());
			structure.setMessage("verification Success");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
			
			
		}
		throw new AdminNotFoundException("Invalid Email Id or password");
	}
	public ResponseEntity<ResponceStructure<String>> delete(int id)
	{
		ResponceStructure<String>structure=new ResponceStructure<>();
		Optional<Admin> dbAdmin= adminDao.findById(id);
		if(dbAdmin.isPresent())
		{
			adminDao.delete(id);
			
			structure.setData("Admin Found");
			structure.setMessage("delete");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
			
			
		}
		throw new AdminNotFoundException("Cannot delete Admin ad Id is Invalid");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

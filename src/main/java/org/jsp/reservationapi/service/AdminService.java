package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.AdminDao;
import org.jsp.reservationapi.dto.AdminResponse;
import org.jsp.reservationapi.dto.AdminResquest;
import org.jsp.reservationapi.dto.ResponceStructure;
import org.jsp.reservationapi.exception.AdminNotFoundException;
import org.jsp.reservationapi.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class AdminService 
{
	@Autowired
	private AdminDao adminDao;
	public   ResponseEntity<ResponceStructure<AdminResponse>> saveAdmin(AdminResquest adminRequest)
	{
		ResponceStructure<AdminResponse> structure=new ResponceStructure<>();
		structure.setMessage("Admin saved");
		Admin admin=adminDao.saveAdmin(mapToAdmin(adminRequest));
		structure.setData(mapToAdminResponse(admin));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
		
	}
	public ResponseEntity<ResponceStructure<AdminResponse>> update(AdminResquest adminRequest,int id)
	{
		Optional<Admin> recAdmin= adminDao.findById(id);
		ResponceStructure<AdminResponse> structure=new ResponceStructure<>();
		if(recAdmin.isPresent())
		{
			Admin dbAdmin=recAdmin.get();
			dbAdmin.setEmail(adminRequest.getEmail());
			dbAdmin.setGst_number(adminRequest.getGst_number());
			dbAdmin.setName(adminRequest.getName());
			dbAdmin.setPhone(adminRequest.getPhone());
			dbAdmin.setPassword(adminRequest.getPassword());
			dbAdmin.setTravles_name(adminRequest.getTravles_name());
			structure.setData(mapToAdminResponse(adminDao.saveAdmin(dbAdmin)));
			structure.setMessage("Admin Update");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure);
			
		}
		throw new AdminNotFoundException("Cannot Updare Admin as Id is Invalid");
		
	}
	public ResponseEntity<ResponceStructure<AdminResponse>> findById(int id)
	{
		ResponceStructure<AdminResponse>structure=new ResponceStructure<>();
		Optional<Admin> dbAdmin= adminDao.findById(id);
		if(dbAdmin.isPresent())
		{
			structure.setData(mapToAdminResponse(dbAdmin.get()));
			structure.setMessage("Admin Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new AdminNotFoundException("Invalid Admin Id");
	}
	public ResponseEntity<ResponceStructure<AdminResponse>> verify(long phone,String password)
	{
		ResponceStructure<AdminResponse>structure=new ResponceStructure<>();
		Optional<Admin> dbAdmin= adminDao.verify(phone, password);
		if(dbAdmin.isPresent())
		{
			structure.setData(mapToAdminResponse(dbAdmin.get()));
			structure.setMessage("verification Success");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
			
			
		}
		throw new AdminNotFoundException("Invalid Phone number or Password");
	}
	public ResponseEntity<ResponceStructure<AdminResponse>> verify(String email,String password)
	{
		ResponceStructure<AdminResponse>structure=new ResponceStructure<>();
		Optional<Admin> dbAdmin= adminDao.verify(email, password);
		if(dbAdmin.isPresent())
		{
			structure.setData(mapToAdminResponse(dbAdmin.get()));
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
	private Admin mapToAdmin(AdminResquest adminRequest)
	{
		return Admin.builder().email(adminRequest.getEmail()).name(adminRequest.getName()).phone(adminRequest.getPhone())
				.gst_number(adminRequest.getGst_number()).travles_name(adminRequest.getTravles_name()).password(adminRequest.getPassword()).build();
				
	}
	private AdminResponse mapToAdminResponse(Admin admin)
	{
		return AdminResponse.builder().name(admin.getName()).email(admin.getEmail()).phone(admin.getPhone())
				.gst_number(admin.getGst_number()).travles_name(admin.getTravles_name()).password(admin.getPassword()).build();
		
	}
	
	
}

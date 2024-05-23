package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.ResponceStructure;
import org.jsp.reservationapi.model.Admin;
import org.jsp.reservationapi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admins")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	@PostMapping
	public ResponseEntity<ResponceStructure<Admin>>saveAdmin(@RequestBody Admin admin)
	{
		return adminService.saveAdmin(admin);
	}
	@PutMapping
	public ResponseEntity<ResponceStructure<Admin>>updateAdmin(@RequestBody Admin admin)
	{
		return adminService.update(admin);
	}
	@GetMapping("{id}")
	public ResponseEntity<ResponceStructure<Admin>>saveAdmin(@PathVariable int id)
	{
		return adminService.findById(id);
	}
	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponceStructure<Admin>>verify(@RequestParam long phone,@RequestParam String password)
	{
		return adminService.verify(phone, password);
	}
	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponceStructure<Admin>>verify(@RequestParam String email,@RequestParam String password)
	{
		return adminService.verify(email, password);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponceStructure<String>>delete(@PathVariable int id)
	{
		return adminService.delete(id);
	}

}

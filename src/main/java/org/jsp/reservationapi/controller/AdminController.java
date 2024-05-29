package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.AdminResponse;
import org.jsp.reservationapi.dto.AdminResquest;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admins")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	@PostMapping
	public ResponseEntity<ResponceStructure<AdminResponse>> saveAdmin(@Valid @RequestBody AdminResquest adminRequest)
	{
		return adminService.saveAdmin(adminRequest);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ResponceStructure<AdminResponse>> updateAdmin(@RequestBody AdminResquest adminRequest,@PathVariable int id)
	{
		return adminService.update(adminRequest,id);
	}
	@GetMapping("{id}")
	public ResponseEntity<ResponceStructure<AdminResponse>> saveAdmin(@PathVariable int id)
	{
		return adminService.findById(id);
	}
	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponceStructure<AdminResponse>> verify(@RequestParam long phone,@RequestParam String password)
	{
		return adminService.verify(phone, password);
	}
	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponceStructure<AdminResponse>> verify(@RequestParam String email,@RequestParam String password)
	{
		return adminService.verify(email, password);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponceStructure<String>>delete(@PathVariable int id)
	{
		return adminService.delete(id);
	}

}

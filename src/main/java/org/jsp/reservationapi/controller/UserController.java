package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.ResponceStructure;
import org.jsp.reservationapi.model.User;
import org.jsp.reservationapi.service.UserService;
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
@RequestMapping("/api/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	@PostMapping
	public ResponseEntity<ResponceStructure<User>>saveUser(@RequestBody User User)
	{
		return userService.saveUser(User);
	}
	@PutMapping
	public ResponseEntity<ResponceStructure<User>>updateUser(@RequestBody User User)
	{
		return userService.update(User);
	}
	@GetMapping("{id}")
	public ResponseEntity<ResponceStructure<User>>saveUser(@PathVariable int id)
	{
		return userService.findById(id);
	}
	@PostMapping("/verify-by-phone")
	public ResponseEntity<ResponceStructure<User>>verify(@RequestParam long phone,@RequestParam String password)
	{
		return userService.verify(phone, password);
	}
	@PostMapping("/verify-by-email")
	public ResponseEntity<ResponceStructure<User>>verify(@RequestParam String email,@RequestParam String password)
	{
		return userService.verify(email, password);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponceStructure<String>>delete(@PathVariable int id)
	{
		return userService.delete(id);
	}

}

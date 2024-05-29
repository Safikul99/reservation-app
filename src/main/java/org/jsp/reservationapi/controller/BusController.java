package org.jsp.reservationapi.controller;

import org.jsp.reservationapi.dto.ResponceStructure;
import org.jsp.reservationapi.model.Bus;
import org.jsp.reservationapi.model.User;
import org.jsp.reservationapi.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buss")
public class BusController 
{
	@Autowired
	private BusService busService;
	@PostMapping
	public ResponseEntity<ResponceStructure<Bus>>saveBus(@RequestBody Bus bus)
	{
		return busService.saveBus(bus);
	}
	@GetMapping("{id}")
	public ResponseEntity<ResponceStructure<Bus>>saveBus(@PathVariable int id)
	{
		return busService.findById(id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponceStructure<String>>delete(@PathVariable int id)
	{
		return busService.delete(id);
	}
 
}

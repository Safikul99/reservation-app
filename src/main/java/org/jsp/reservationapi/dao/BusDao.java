package org.jsp.reservationapi.dao;

import java.util.Optional;

import org.jsp.reservationapi.model.Bus;
import org.jsp.reservationapi.model.User;
import org.jsp.reservationapi.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao 
{
	@Autowired
	private BusRepository busRepository;
	public Bus savebus(Bus bus)
	{
		return busRepository.save(bus);
	}
	public Optional<Bus>findById(int id)
	{
		return busRepository.findById(id);
	}
	public void delete(int id)
	{
		busRepository.deleteById(id);
	}
} 

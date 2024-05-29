package org.jsp.reservationapi.service;

import java.util.Optional;

import org.jsp.reservationapi.dao.UserDao;
import org.jsp.reservationapi.dto.ResponceStructure;
import org.jsp.reservationapi.exception.UserNotFoundException;
import org.jsp.reservationapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserService 
{
	@Autowired
	private UserDao UserDao;
	public  ResponseEntity<ResponceStructure<User>> saveUser(User user)
	{
		ResponceStructure<User> structure=new ResponceStructure<>();
		structure.setMessage("User saved");
		structure.setData(UserDao.saveuser(user));
		structure.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
		
	}
	public ResponseEntity<ResponceStructure<User>>update(User user)
	{
		Optional<User> recUser= UserDao.findById(user.getId());
		ResponceStructure<User> structure=new ResponceStructure<>();
		if(recUser.isPresent())
		{
			User dbUser=recUser.get();
			dbUser.setEmail(user.getEmail());
			dbUser.setName(user.getName());
			dbUser.setAge(user.getAge());
			dbUser.setPassword(user.getPassword());
			dbUser.setPhone(user.getPhone());
			dbUser.setGender(user.getGender());
			structure.setData(UserDao.saveuser(user));
			structure.setMessage("User Update");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure);
			
		}
		throw new UserNotFoundException("Cannot Update User as Id is Invalid");
		
	}
	public ResponseEntity<ResponceStructure<User>>findById(int id)
	{
		ResponceStructure<User>structure=new ResponceStructure<>();
		Optional<User> dbUser= UserDao.findById(id);
		if(dbUser.isPresent())
		{
			structure.setData(dbUser.get());
			structure.setMessage("User Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		}
		throw new UserNotFoundException("Invalid User Id");
	}
	public ResponseEntity<ResponceStructure<User>>verify(long phone,String password)
	{
		ResponceStructure<User>structure=new ResponceStructure<>();
		Optional<User> dbUser= UserDao.verify(phone, password);
		if(dbUser.isPresent())
		{
			structure.setData(dbUser.get());
			structure.setMessage("verification Success");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
			
			
		}
		throw new UserNotFoundException("Invalid Phone number or Password");
	}
	public ResponseEntity<ResponceStructure<User>>verify(String email,String password)
	{
		ResponceStructure<User>structure=new ResponceStructure<>();
		Optional<User> dbUser= UserDao.verify(email, password);
		if(dbUser.isPresent())
		{
			structure.setData(dbUser.get());
			structure.setMessage("verification Success");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
			
			
		}
		throw new UserNotFoundException("Invalid Email Id or password");
	}
	public ResponseEntity<ResponceStructure<String>> delete(int id)
	{
		ResponceStructure<String>structure=new ResponceStructure<>();
		Optional<User> dbUser= UserDao.findById(id);
		if(dbUser.isPresent())
		{
			UserDao.delete(id);
			
			structure.setData("User Found");
			structure.setMessage("delete");
			structure.setStatusCode(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
			
			
		}
		throw new UserNotFoundException("Cannot delete User ad Id is Invalid");
	}
	
	
}

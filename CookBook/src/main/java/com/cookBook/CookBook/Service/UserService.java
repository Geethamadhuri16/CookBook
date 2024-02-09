package com.cookBook.CookBook.Service;

import org.springframework.http.ResponseEntity;

import com.cookBook.CookBook.Model.User;

public interface UserService {
	public ResponseEntity<String> register(User u);
	public ResponseEntity<String> login(String mail,String pass);
	public ResponseEntity<String> del(Long id);
	

}

package com.cookBook.CookBook.ServiceImp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cookBook.CookBook.Model.User;
import com.cookBook.CookBook.Repo.UserRepo;
import com.cookBook.CookBook.Service.UserService;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepo userRepository;

    @Override
    public ResponseEntity<String> register(User u) {
    	
        try {
        	User user=userRepository.findByEmail(u.getEmail());
        	if(user==null) {
        		userRepository.save(u);
        		 return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully.");
        	}else {
        		return new ResponseEntity<>(null,HttpStatus.ALREADY_REPORTED);
        	}
           
        } catch (Exception e) {
        	System.out.println(e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }

    @Override
    public ResponseEntity<String> login(String mail, String pass) {
        try {
            User user = userRepository.findByEmailAndPassword(mail, pass);
            if (user != null) {
                return ResponseEntity.ok("Login successful.");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error.");
        }
    }

    @Override
    public ResponseEntity<String> del(Long id) {
        try {
        	User user=userRepository.getById(id);
        	if(user==null) {
        		userRepository.deleteById(id);
        		 return ResponseEntity.status(HttpStatus.CREATED).body("User deleted successfully.");
        	}else {
        		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        	}
        	
            
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error.");
        }
    }
}


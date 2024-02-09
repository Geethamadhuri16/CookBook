package com.cookBook.CookBook.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cookBook.CookBook.Model.Comment;
import com.cookBook.CookBook.Repo.CommentRepo;
import com.cookBook.CookBook.Service.CommentService;



@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	private CommentRepo repo;

	@Override
	public ResponseEntity<String> addComment(Comment c) {
		try {
			repo.save(c);
			return new  ResponseEntity<>("added Comment Successfully",HttpStatus.OK);
		}catch(Exception e){
			return new  ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> delComment(Long id) {
		try {
			Comment c=repo.findById(id).orElse(null);
			if(c!=null) {
				
				repo.delete(c);
				return new  ResponseEntity<>("deleted Comment Successfully",HttpStatus.OK);
			}else {
				return new  ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			return new  ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<String> replyComment(Long commentId, String reply) {
		try {
			Comment c=repo.getById(commentId);
			if(c!=null) {
				c.addreply(reply);	
				repo.save(c);
				return new  ResponseEntity<>("Replied for the Comment Successfully",HttpStatus.OK);
			}else {
				return new  ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			return new  ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	

}

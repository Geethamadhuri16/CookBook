package com.cookBook.CookBook.Service;

import org.springframework.http.ResponseEntity;

import com.cookBook.CookBook.Model.Comment;

public interface CommentService {
	public ResponseEntity<String> addComment(Comment c);
	public ResponseEntity<String> delComment(Long id);
	public ResponseEntity<String> replyComment(Long commentId,String reply);
	
	

}

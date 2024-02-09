package com.cookBook.CookBook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cookBook.CookBook.Model.Comment;
import com.cookBook.CookBook.Service.CommentService;
import com.cookBook.CookBook.ServiceImp.CommentServiceImp;
@RestController
public class CommentController {
	
	@Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @DeleteMapping("/deleteComment")
    public ResponseEntity<String> deleteComment(@RequestParam Long id) {
        return commentService.delComment(id);
    }

    @PostMapping("/replyComment")
    public ResponseEntity<String> replyToComment(@RequestParam Long commentId, @RequestParam String reply) {
        return commentService.replyComment(commentId, reply);
    }

}

package com.cookBook.CookBook.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookBook.CookBook.Model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}

package com.cookBook.CookBook.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Entity
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType
	.IDENTITY)
	private Long id;
	private String comment;
	@ManyToOne
	@JoinColumn(name = "Commentor_Id", nullable = false)
	private User commentor;
	@ManyToOne
	@JoinColumn(name = "RecipeOwner_Id", nullable = false)
	private User owner;
	@ElementCollection
	private List<String> reply;
	private LocalDateTime timestamp;
	@ManyToOne
	@JoinColumn(name = "Recipe_Id", nullable = false)
	private Recipe recipe;
	@PrePersist
    protected void onCreate() {
        timestamp = LocalDateTime.now();
    }
	
	public void addreply(String reply) {
		this.reply.add(reply);
		
	}

}

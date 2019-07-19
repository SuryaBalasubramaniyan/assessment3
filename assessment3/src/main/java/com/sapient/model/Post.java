package com.sapient.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Post")
public class Post implements Serializable{

    @Id
    @Column(name="id")
    private long id;

    @Column(name="u_id")
    private long u_id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="body")
    private String body;

	
    
}
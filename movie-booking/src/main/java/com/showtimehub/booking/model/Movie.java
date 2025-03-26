package com.showtimehub.booking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "movies")
public class Movie {
    @Id
    private ObjectId id;
    private String title;
    private String description;
    private int duration;
    private String genre;

    // Getters and Setters
}
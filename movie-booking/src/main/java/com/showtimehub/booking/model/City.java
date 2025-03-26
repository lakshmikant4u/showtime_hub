package com.showtimehub.booking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cities")
public class City {
    @Id
    private ObjectId id;
    private String name;
    private String state;
    private String country;

    // Getters and Setters
}
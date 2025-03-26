package com.showtimehub.booking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "shows")
public class Show {
    @Id
    private ObjectId id;
    private ObjectId movie;
    private ObjectId theatre;
    private Date date;
    private String time;
    private List<ObjectId> seats;

    // Getters and Setters
}
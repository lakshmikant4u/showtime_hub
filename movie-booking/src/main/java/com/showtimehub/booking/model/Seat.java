package com.showtimehub.booking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "seats")
public class Seat {
    @Id
    private ObjectId id;
    private ObjectId show;
    private String row;
    private int number;
    private boolean isBooked;
}
package com.showtimehub.booking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.List;

@Data
@Document(collection = "bookings")
public class Booking {
    @Id
    private ObjectId id;
    private String customerName;
    private String customerEmail;
    private ObjectId show;
    private List<ObjectId> seats;
    private double totalPrice;
    private double discount;

    @Version
    private Long version;
}
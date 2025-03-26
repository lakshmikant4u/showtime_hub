package com.showtimehub.booking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "offers")
public class Offer {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private int discountPercentage;
    private List<ObjectId> applicableCities;
    private List<ObjectId> applicableTheatres;
    private Date startDate;
    private Date endDate;

    // Getters and Setters
}
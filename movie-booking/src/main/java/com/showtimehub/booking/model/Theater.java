package com.showtimehub.booking.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "theatres")
public class Theater {
    @Id
    private ObjectId id;
    private String name;
    private String address;
    private ObjectId city;
    private List<ObjectId> shows;
}
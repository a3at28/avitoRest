package tech.itpark.avito.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Flat {
    private long id;
    private String image;
    private int rooms;
    private double area;
    private int storey;
    private int storeyInHouse;
    private int price;
    private String check;
    private String complex;
    private String address;
    private String metro;
    private double distanceToMetro;
    private String seller;
    private long created;
    private boolean removed;

}

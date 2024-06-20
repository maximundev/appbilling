package com.billing.apibilling.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Producto {

    private int idProduct;
    private String name;
    private int stock;
    private String category;
    private Long price;
    private int active;

}

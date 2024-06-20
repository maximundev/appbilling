package com.billing.apibilling.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrdenCompra {

    private int idOrdenCompra;
    private Date dateBuy;
    private String clientName;
    private int clientId;

}

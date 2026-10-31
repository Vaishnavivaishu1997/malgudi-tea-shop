package com.vaishnavi.malgudi.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {

    private List<OrderItemRequest> items;
}
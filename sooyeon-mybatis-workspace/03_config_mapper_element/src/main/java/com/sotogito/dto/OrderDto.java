package com.sotogito.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {

    private int orderCode;
    private String orderDate;
    private String orderTime;
    private int totalOrderPrice;

    // 1:N - has-many
    private List<OrderMenuDto> orderMenuList;

}

package com.kyungbae.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderDto {

    private int orderCode;
    private String orderDate;
    private String orderTime;
    private int totalOrderPrice;

    // 해당 주문에 포함되어있는 주문메뉴목록 필드
    // 1:N (has-many) 관계
    private List<OrderMenuDto> orderMenuList;

}

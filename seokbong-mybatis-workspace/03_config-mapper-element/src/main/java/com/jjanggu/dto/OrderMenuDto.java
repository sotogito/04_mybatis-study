package com.jjanggu.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderMenuDto {

    private int orderCode;
    private int menuCode;
    private int orderAmount;

}

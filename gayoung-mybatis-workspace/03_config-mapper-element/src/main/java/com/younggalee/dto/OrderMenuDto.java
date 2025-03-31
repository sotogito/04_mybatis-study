package com.younggalee.dto;
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

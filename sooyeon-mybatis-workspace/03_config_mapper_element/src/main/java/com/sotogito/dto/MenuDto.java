package com.sotogito.dto;

import lombok.*;

/// 내부적으로 기본 dto기능을 가짐
@NoArgsConstructor/// 기본 생성자
@AllArgsConstructor/// 모든 필드 생성자
@Getter
@Setter
@ToString
public class MenuDto {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

}
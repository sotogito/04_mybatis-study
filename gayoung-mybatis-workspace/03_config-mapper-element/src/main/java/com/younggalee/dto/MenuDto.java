package com.younggalee.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MenuDto {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    // JOIN
    // 해당 메뉴가 가지는 카테고리 정보를 담기위한 DTO
    // 1:1 (has-a) 포함관계
    private CategoryDto category;

}

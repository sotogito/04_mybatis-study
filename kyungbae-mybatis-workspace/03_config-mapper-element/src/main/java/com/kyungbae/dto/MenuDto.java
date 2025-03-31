package com.kyungbae.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MenuDto {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    // 해당 메뉴가 가지는 카테고리 정보를 담기위한 DTO
    // 1:1 (has-a) 관계
    private CategoryDto category;

}

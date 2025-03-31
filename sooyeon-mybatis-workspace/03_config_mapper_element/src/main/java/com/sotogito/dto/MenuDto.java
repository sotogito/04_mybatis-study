package com.sotogito.dto;

import lombok.*;

/// 내부적으로 기본 dto기능을 가짐
@NoArgsConstructor/// 기본 생성자
@AllArgsConstructor/// 모든 필드 생성자
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

    /// 메뉴가 가지는 카테고리 정보를 담기 위한 dto
    /// 1:1관계 - has a
    private CategoryDto category;

}
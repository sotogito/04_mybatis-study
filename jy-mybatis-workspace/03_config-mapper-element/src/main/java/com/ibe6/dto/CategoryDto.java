package com.ibe6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class CategoryDto {

    // private int cCode; => setcCode() getcCode() 메소드 필요
    //                    => setCCode() getCCode()
    // 소문자 2글자 이상으로 시작해야함 (네이밍규칙)

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}

package com.jjanggu.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoryDto {

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}

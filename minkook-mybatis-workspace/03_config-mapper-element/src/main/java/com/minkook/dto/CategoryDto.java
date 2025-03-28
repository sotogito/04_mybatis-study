package com.minkook.dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
}

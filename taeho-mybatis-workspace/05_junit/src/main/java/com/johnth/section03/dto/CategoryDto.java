package com.johnth.section03.dto;

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
    private int refCategoryCode;

}

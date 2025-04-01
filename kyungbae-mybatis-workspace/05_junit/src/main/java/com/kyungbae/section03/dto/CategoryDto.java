package com.kyungbae.section03.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class CategoryDto {

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}

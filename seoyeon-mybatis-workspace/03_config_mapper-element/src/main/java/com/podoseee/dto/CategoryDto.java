package com.podoseee.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CategoryDto {

/*    private int cCode;    // => setcCode()   getcCode()  메소드 필요
                          // => setCCode()   getCCode()*/

    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}

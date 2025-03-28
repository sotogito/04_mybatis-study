package com.sotogito.run;

import com.sotogito.dto.CategoryDto;
import com.sotogito.dto.MenuDto;
import com.sotogito.service.MenuService;

import java.util.Scanner;

public class Application5 {
    public static void main(String[] args) {
        ///  신규 카테고리 등록
        /**
         * JDBC의 경우
         * 1. insert tbl_Category 정보 가져오기
         * 2. 마지막 카테고리 코드 번호 가져오기
         * 3. 메뉴 추가하기
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("신규 카테고리명, 상위 카테고리 번호");
        String categoryName = sc.nextLine();
        Integer refCategoryCode = Integer.parseInt(sc.nextLine());

        System.out.println("신규 메뉴의 이름, 가격, 주문 가능 여부");
        String menuName = sc.nextLine();
        int menuPrice = Integer.parseInt(sc.nextLine());
        String orderableStatus = sc.nextLine().toLowerCase();

        CategoryDto category = CategoryDto.builder()
                .categoryName(categoryName)
                .refCategoryCode(refCategoryCode)
                .build();

        MenuDto menu = MenuDto.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .orderableStatus(orderableStatus)
                .category(category)
                .build();


        System.out.println("추가 전 : "+ menu);
        int result = new MenuService().insertCategoryAndMenu(menu);
        System.out.println("추가 후 : "+ menu);
    }
}

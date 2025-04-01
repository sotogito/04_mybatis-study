package com.kyungbae.run;

import com.kyungbae.dto.CategoryDto;
import com.kyungbae.dto.MenuDto;
import com.kyungbae.service.MenuService;

import java.util.Scanner;

public class Application5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 신규 카테고리 등록하면서 해당 카테고리번호로 메뉴 추가
        System.out.print("신규카테고리명: ");
        String categoryName = sc.nextLine();
        System.out.print("상위카테고리번호: ");
        Integer refCategoryCode = sc.nextInt();
        sc.nextLine();

        /*CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(categoryName);
        categoryDto.setRefCategoryCode(refCategoryCode);*/

        CategoryDto categoryDto = CategoryDto.builder()
                .categoryName(categoryName)
                .refCategoryCode(refCategoryCode)
                .build();

        System.out.print("신규메뉴명: ");
        String menuName = sc.nextLine();
        System.out.print("가격: ");
        int menuPrice = sc.nextInt();
        sc.nextLine();
        System.out.print("주문가능여부: ");
        String orderableStatus = sc.nextLine().toUpperCase();

        MenuDto menu = MenuDto.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .orderableStatus(orderableStatus)
                .category(categoryDto)
                .build();

        int result = new MenuService().insertCategoryAndMenu(menu);
        if (result > 0) {
            System.out.println("추가 성공");
        } else {
            System.out.println("추가 실패");
        }



    }
}

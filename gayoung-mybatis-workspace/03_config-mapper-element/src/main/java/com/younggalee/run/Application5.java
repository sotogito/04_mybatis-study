package com.younggalee.run;

import com.younggalee.dto.CategoryDto;
import com.younggalee.dto.MenuDto;
import com.younggalee.service.MenuService;

import java.util.Scanner;

public class Application5 {
    public static void main(String[] args) {
        // 신규 카테고리 등록하면서 해당 카테고리번호로 메뉴 추가
        Scanner sc = new Scanner(System.in);
        System.out.print("신규카테고리명: ");
        String categoryName = sc.nextLine();
        System.out.print("신규카테고리의 상위카테고리번호: ");
        Integer refCategoryCode = sc.nextInt();
        sc.nextLine();

        CategoryDto category = CategoryDto.builder()
                .categoryName(categoryName)
                .refCategoryCode(refCategoryCode)
                .build();

        System.out.print("신규메뉴명: ");
        String menuName = sc.nextLine();
        System.out.print("신규메뉴가격: ");
        int menuPrice = sc.nextInt();
        sc.nextLine();
        System.out.print("주문가능여부: ");
        String orderableStatus = sc.nextLine().toUpperCase();

        MenuDto menu = MenuDto.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .orderableStatus(orderableStatus)
                .category(category)
                .build();

        int result = new MenuService().insertCategoryAndMenu(menu);

        if(result > 0){
            System.out.println("등록 성공");
        }else{
            System.out.println("등록 실패");
        }

    }
}
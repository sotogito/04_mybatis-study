package com.sotogito.section03.view;

import com.sotogito.section03.dto.CategoryDto;
import com.sotogito.section03.dto.MenuDto;

import java.util.List;

public class ResultView {
    /// 조회된 메뉴 목록을 출력해주는 화면
    public static void displayMenuList(List<MenuDto> list) {
        if (list.isEmpty()) {
            System.out.println("조회된 메뉴가 업음");
            return;
        }
        list.forEach(menu ->
                System.out.printf("%d\t%s\t%,d원\t%d\t%s\n"
                                        , menu.getMenuCode()
                                        , menu.getMenuName()
                                        , menu.getMenuPrice()
                                        , menu.getCategoryCode()
                                        , menu.getOrderableStatus()
        ));
    }

    /// 카테고리 줄력
    public static void displayCategoryList(List<CategoryDto> list) {
        for(CategoryDto categoryDto : list) {
            System.out.printf("%d. %s\n"
                                    , categoryDto.getCategoryCode()
                                    , categoryDto.getCategoryName());
        }
        System.out.println();
    }


    /// 한건의 메뉴 정보 출력
    public static void displayMenu(MenuDto menu) {
        if(menu == null) {
            System.out.println("조회된 메뉴정보가 없습니다.");
            return;
        }
        System.out.println("====메뉴 정보====");
        System.out.println("Code : "+menu.getMenuCode());
        System.out.println("Name : "+menu.getMenuName());
        System.out.println("Price : " + menu.getMenuPrice());
        System.out.println("CategoryCode : "+menu.getCategoryCode());
        System.out.println("OrderableStatus : "+("Y".equalsIgnoreCase(menu.getOrderableStatus()) ? "가능" : "불가능"));
        System.out.println();
    }

    /// 등록, 수정, 삭제 요청시 결과를 출력해주는 화면
    public static void displayResult(String type, int result) {
        System.out.println(type + " " + (result > 0 ? "성" : "실"));
    }


}

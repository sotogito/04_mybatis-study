package com.younggalee.run;

import com.younggalee.dto.MenuDto;
import com.younggalee.service.MenuService;

import java.util.List;

public class Application1 {
    public static void main(String[] args) {
        // 메뉴(번호,명,가격) 목록 조회
        List<MenuDto> list1 = new MenuService().testResultMapExtends1();
        for ( MenuDto menu : list1){
            System.out.println(menu);
        }

        // 메뉴(번호,명,가격,카테,주문여부) 목록 조회
        List<MenuDto> list2 = new MenuService().testResultMapExtends2();
        list2.forEach(System.out::println);
    }




    // 어떤 화면인가에 따라서 필요한 데이터들이 다름(생성객체)
}

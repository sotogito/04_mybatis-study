package com.jjanggu.run;

import com.jjanggu.dto.MenuDto;
import com.jjanggu.service.MenuService;

import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        // 메뉴(번호,메뉴명,가격) 목록 조회
        List<MenuDto> list1 = new MenuService().testResultMapExtends1();
        for (MenuDto menu : list1) {
            System.out.println(menu);
        }

        System.out.println("=========================================");
        // 메뉴(번호, 메뉴명, 가격, 카테고리,주문가능여부) 목록 조회
        List<MenuDto> list2 = new MenuService().testResultMapExtends2();
        list2.forEach(System.out::println);
    }
}

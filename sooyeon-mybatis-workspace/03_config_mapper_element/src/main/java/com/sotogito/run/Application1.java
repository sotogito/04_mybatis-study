package com.sotogito.run;


import com.sotogito.dto.MenuDto;
import com.sotogito.service.MenuService;

import java.util.List;

public class Application1 {
    public static void main(String[] args) {
        /// 1. 메뉴(번호, 메뉴명, 가격) 목록 조회
        List<MenuDto> test1 = new MenuService().testResultMapExtend1();
        test1.forEach(System.out::println);

        System.out.println("\n\n\n\n");

        /// 2. 메뉴(다) 목록 조회
        List<MenuDto> test2 = new MenuService().testResultMapExtend2();
        test2.forEach(System.out::println);
    }
}

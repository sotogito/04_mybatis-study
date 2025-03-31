package com.sotogito.run;

import com.sotogito.dto.MenuDto;
import com.sotogito.service.MenuService;

public class Application4 {
    public static void main(String[] args) {
        ///  메뉴 번호로 메뉴 검색
        MenuDto menu = new MenuService().testSql(1);
        System.out.println(menu);
    }
}

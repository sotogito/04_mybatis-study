package com.ibe6.run;

import com.ibe6.dto.MenuDto;

public class LombokTest {
    public static void main(String[] args) {
        MenuDto menu = new MenuDto();
        menu.setMenuName("메뉴명");
        System.out.println(menu.getMenuName());
    }
}

package com.podoseee.section01.xml;

import com.podoseee.dto.MenuDto;

import java.util.List;

public class Application4_SelectList {
    public static void main(String[] args) {

        // 1. 전체 메뉴들의 메뉴명만 조회
        List<String> list = new MenuService().selectMenuNameList();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("==============");

        // 2. 주문가능한 전체 메뉴(메뉴번호, 메뉴명, 가격, 카테고리, 주문가능여부) 조회
        List<MenuDto> menuList = new MenuService().selectOrderableMenuList();
        for (MenuDto menu : menuList){
            System.out.println(menu);
        }
    }
}

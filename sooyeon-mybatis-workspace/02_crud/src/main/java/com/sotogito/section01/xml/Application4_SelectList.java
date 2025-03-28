package com.sotogito.section01.xml;

import com.sotogito.dto.MenuDto;

import java.awt.*;
import java.util.List;

public class Application4_SelectList {
    public static void main(String[] args) {
        /// 1. 전체 메뉴들의 메뉴명만 조회
        List<String> menuNameList = new MenuService().selectMenuNameList();
        menuNameList.forEach(System.out::println);

        System.out.println("\n==========================\n");

        /// 2. 주문 가능한 전체 메뉴(메뉴 번호, 메뉴명, 가격, 카테고리, 주문가능여부 조회)
        List<MenuDto> menuList = new MenuService().selectOrderableMenuList();
        menuList.forEach(System.out::println);
    }
}

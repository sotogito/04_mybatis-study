package com.sotogito.section01.xml;

import com.sotogito.dto.MenuDto;

import java.util.Scanner;

public class Application_Insert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴명, 메뉴가격, 카테고리번호, 주문가능여부");
        String menuName = sc.nextLine();
        String menuPrice = sc.nextLine();
        String category = sc.nextLine();
        String orderable = sc.nextLine().toLowerCase();

        MenuDto menu = new MenuDto();
        menu.setMenuName(menuName);
        menu.setMenuPrice(Integer.parseInt(menuPrice));
        menu.setCategoryCode(Integer.parseInt(category));
        menu.setOrderableStatus(orderable);

        int result = new MenuService().insertMenu(menu);

        if (result > 0) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }
    }

}

package com.minkook.section01.xml;

import com.minkook.dto.MenuDto;

import java.util.Scanner;

public class Application_Insert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴명: ");
        String menuName = sc.nextLine();
        System.out.print("메뉴가격: ");
        String menuPrice = sc.nextLine();
        System.out.print("카테고리번호: ");
        String category = sc.nextLine();
        System.out.print("주문가능여부: ");
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

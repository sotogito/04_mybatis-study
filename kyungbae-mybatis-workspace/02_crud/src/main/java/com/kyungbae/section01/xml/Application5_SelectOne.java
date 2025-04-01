package com.kyungbae.section01.xml;

import com.kyungbae.dto.MenuDto;

import java.util.Scanner;

public class Application5_SelectOne {
    public static void main(String[] args) {

        // 1. 주문가능한 메뉴의 총 개수
        int totalCount = new MenuService().selectOrderableMenuCount();
        if (totalCount > 0) {
            System.out.println("주문가능한 메뉴의 총 개수 : " + totalCount);
        } else {
            System.out.println("주문가능한 메뉴가 없습니다.");
        }

        // 2. 메뉴번호로 메뉴 검색
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴번호 입력: ");
        String menuCode = sc.nextLine();
        MenuDto menu = new MenuService().selectMenuByMenuCode(Integer.parseInt(menuCode));
        if (menu != null) {
            System.out.println(menu);
        } else {
            System.out.println("조회된 메뉴가 없습니다.");
        }

    }
}

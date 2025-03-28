package com.sotogito.section01.xml;

import com.sotogito.dto.MenuDto;

import java.util.Scanner;

public class Application_SelectOne {
    public static void main(String[] args) {
        /// 1. 주문가능한 메뉴의 총 수
        int totalCount = new MenuService().selectOrderableMenuCount();
        System.out.println(totalCount);

        Scanner sc = new Scanner(System.in);
        ///  2. 메뉴번호로 메뉴 검색
        System.out.println("메뉴 검색");
        String menuCode = sc.nextLine();

        MenuDto searchMenu = new MenuService().selectMenuByMenuCode(Integer.parseInt(menuCode));
        if(searchMenu != null) {
            System.out.println(searchMenu);
        }else {
            System.out.println("없음");
        }

    }
}

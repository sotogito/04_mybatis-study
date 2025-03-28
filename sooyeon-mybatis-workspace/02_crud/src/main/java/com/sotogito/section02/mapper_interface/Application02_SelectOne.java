package com.sotogito.section02.mapper_interface;

import com.sotogito.dto.MenuDto;
import com.sotogito.section01.xml.MenuDao;

import java.util.Scanner;

public class Application02_SelectOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("검색할 메뉴 입력");
        String menuCode = sc.nextLine();

        MenuDto menu = new MenuService().selectMenuByCode(Integer.parseInt(menuCode));

        if (menu != null) {
            System.out.println(menu);
        }else {
            System.out.println("없");
        }

        /// 2. 사용자가 입력한 가격 이라의 메뉴의 총 개수
        System.out.println("가격");
        String menuPrice = sc.nextLine();

        int menuCountResult = new MenuService().selectMenuCountBelowPrice(Integer.parseInt(menuPrice));
        System.out.println(menuCountResult);

    }
}

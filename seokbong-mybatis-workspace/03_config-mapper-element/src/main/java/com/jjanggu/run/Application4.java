package com.jjanggu.run;

import com.jjanggu.dto.MenuDto;
import com.jjanggu.service.MenuService;

import java.util.Scanner;

public class Application4 {

    public static void main(String[] args) {
        // 메뉴번호로 메뉴검색
        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 메뉴번호: ");
        int menuCode = sc.nextInt();

        MenuDto menu = new MenuService().testSql(menuCode);
        System.out.println(menu);
    }
}

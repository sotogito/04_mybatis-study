package com.kyungbae.run;

import com.kyungbae.dto.MenuDto;
import com.kyungbae.service.MenuService;

import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 메뉴번호로 메뉴검색
        System.out.print("메뉴번호: ");
        int code = sc.nextInt();

        MenuDto menu = new MenuService().testSql(code);
        System.out.println(menu);

    }
}

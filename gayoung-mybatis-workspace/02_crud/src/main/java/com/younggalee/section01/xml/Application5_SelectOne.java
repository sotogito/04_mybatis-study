package com.younggalee.section01.xml;

import com.younggalee.dto.MenuDto;

import java.util.Scanner;

public class Application5_SelectOne {
    public static void main(String[] args) {
        // 2. 메뉴번호로 조회하기
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 메뉴번호 : ");
        String code = sc.nextLine();
        MenuDto menu = new MenuService().selectMenuByCode(Integer.parseInt(code));

        if (menu == null){
            System.out.println("검색결과가 없습니다.");
        } else {
            System.out.println(menu);
        }
    }
}

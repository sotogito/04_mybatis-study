package com.younggalee.section02.mapper_interface;

import com.younggalee.dto.MenuDto;

import java.util.Scanner;

public class Application2_SelectOne {
    public static void main(String[] args) {
        // 1. 메뉴번호로 메뉴검색
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 메뉴번호 : ");
        String code = sc.nextLine();

        MenuDto menu = new MenuService().selectMenuByCode(Integer.parseInt(code));
        if (menu == null){
            System.out.println("해당번호의 메뉴가 존재하지 않습니다.");
        } else {

            System.out.println(menu);
        }

        System.out.print("메뉴의 가격 : ");
        String price = sc.nextLine();


        int count = new MenuService().selectMenuCountByPrice(Integer.parseInt(price));
        System.out.println(count + "개 입니다.");
    }
}

package com.younggalee.section01.xml;

import com.younggalee.dto.MenuDto;

import java.util.Scanner;

public class Appliacation_insert {
    public static void main(String[] args) {
        // 메뉴등록

        // 등록할 메뉴 정보 입력 (view)
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴명 : ");
        String name = sc.nextLine();
        System.out.print("가격 : ");
        int price = sc.nextInt();
        System.out.print("카테고리번호 : ");
        int category = sc.nextInt();
        sc.nextLine();
        System.out.print("주문가능여부 : ");
        String orderableStatus = sc.nextLine();

        //데이터 가공처리 및 DTO에 담기 (controller)
        MenuDto menu = new MenuDto();
        menu.setName(name);
        menu.setPrice(price);
        menu.setCategory(category);
        menu.setOrderableStatus(orderableStatus);

        int result = new MenuService().insertMenu(menu);

        if (result >0){
            System.out.println("등록성공");
        } else {
            System.out.println("등록실패");
        }
    }
}



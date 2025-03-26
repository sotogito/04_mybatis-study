package com.podoseee.section01.xml;

import com.podoseee.dto.MenuDto;

import java.util.Scanner;

public class Application1_Insert {
    public static void main(String[] args) {

        // 메뉴 등록

        // 등록할 메뉴 정보 입력 (view)
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴명: ");
        String name = sc.nextLine();
        System.out.print("메뉴가격: ");
        String price = sc.nextLine();
        System.out.print("카테고리번호: ");
        String category = sc.nextLine();
        System.out.print("주문가능여부: ");
        String orderable = sc.nextLine().toUpperCase();

        // 데이터 가공처리 및 DTO에 담기 (controller)
        MenuDto menu = new MenuDto();
        menu.setMenuName(name);
        menu.setMenuPrice( Integer.parseInt(price) );
        menu.setCategoryCode( Integer.parseInt(category) );
        menu.setOrderableStatus( orderable );

        int result = new MenuService().insertMenu(menu);

        if(result > 0){
            System.out.println("등록 성공");
        }else{
            System.out.println("등록 실패");
        }

    }
}

package com.sotogito.section01.xml;

import com.sotogito.dto.MenuDto;

import java.util.Scanner;

public class Application2_Update {
    public static void main(String[] args) {
        /// 메뉴 정보 수정
        /**
         * 1. 수정정보 입력받기
         * 2. 데이터 가공 및 dto에 입력받기 - controller
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("수정할 메뉴 코드를 입력해주세요");
        String menuCode = sc.nextLine();
        System.out.println("수정 후 메뉴명, 가격, 카테고리  :");
        String menuName = sc.nextLine();
        String menuPrice = sc.nextLine();
        String category = sc.nextLine();

        MenuDto menu = new MenuDto(
                Integer.parseInt(menuCode)
                ,menuName
                ,Integer.parseInt(menuPrice)
                ,Integer.parseInt(category)
        );


        int editResult = new MenuService().updateMenu(menu);

        if (editResult > 0) {
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }
    }
}

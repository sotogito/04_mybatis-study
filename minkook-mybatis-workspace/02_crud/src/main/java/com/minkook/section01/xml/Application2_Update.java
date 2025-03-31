package com.minkook.section01.xml;

import com.minkook.dto.MenuDto;

import java.util.Scanner;

public class Application2_Update {
    public static void main(String [] args){
        //메뉴 정보 수정

        //수정할 내용 입력(view)
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴번호: ");
        String code = sc.nextLine();
        System.out.print("수정정보(메뉴명): ");
        String name = sc.nextLine();
        System.out.print("수정정보(가격): ");
        String price = sc.nextLine();
        System.out.print("수정정보(카테고리번호): ");
        String category = sc.nextLine();

        //데이터 가공 및 DTO에 담기(controller)
        MenuDto menu = new MenuDto(Integer.parseInt(code)
                                  ,name
                                  ,Integer.parseInt(price)
                                  ,Integer.parseInt(category)
                                  );

        int result = new MenuService().updateMenu(menu);
        
        if(result > 0){
            System.out.println("수정 성공");
        }else {
            System.out.println("수정 실패");
        }
    }
}

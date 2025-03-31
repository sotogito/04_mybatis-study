package com.younggalee.section01.xml;

import com.younggalee.dto.MenuDto;

import java.util.Scanner;

public class Application3_delete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴코드 입력 : ");
        String code = sc.nextLine();
        int result = new MenuService().deleteMenu(Integer.parseInt(code));

        if(result > 0){
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }
}

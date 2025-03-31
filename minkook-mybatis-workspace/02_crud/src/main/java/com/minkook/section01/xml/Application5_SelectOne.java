package com.minkook.section01.xml;

import com.minkook.dto.MenuDto;

import java.util.List;
import java.util.Scanner;

public class Application5_SelectOne {
    public static void main(String [] args){
      int totalCount = new MenuService().selectOrderableMenuCount();

        System.out.println("주문가능한 메뉴개수: " + totalCount);

        //2. 메뉴번호로 메뉴 검색
        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 메뉴번호: ");
        String code = sc.nextLine();
        MenuDto menu = new MenuService().selectMenuByCode(Integer.parseInt(code));

        System.out.println(menu);

    }
}

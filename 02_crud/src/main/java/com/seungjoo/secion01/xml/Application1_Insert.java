package com.seungjoo.secion01.xml;

import com.seungjoo.secion01.xml.dto.MenuDto;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Application1_Insert {
    public static void main(String[] args) {


        // 메뉴 등록

        //등록할 메뉴 정보 입력(view)

        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴명:");
        String name = sc.nextLine();
        System.out.println("메뉴가격:");
        String price = sc.nextLine();
        System.out.println("카테고리번호: ");
        String category = sc.nextLine();
        System.out.println("주문 가능여부: ");
        String orderable =sc.nextLine();


        MenuDto menu = new MenuDto();
        menu.setMenuName(name);
        menu.setMenuPrice(Integer.parseInt(price));
        menu.setCategoryCode(Integer.parseInt(category));
        menu.setOrderableStatus(orderable);
    }
}

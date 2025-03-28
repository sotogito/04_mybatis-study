package com.sotogito.section02.mapper_interface;

import com.sotogito.dto.MenuDto;
import com.sotogito.section02.mapper_interface.MenuService;

import java.awt.*;
import java.util.Scanner;

public class Application1_Insert {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴명,가격, 주문가능여부 ");
        String name = sc.nextLine();
        String price = sc.nextLine();
        String orderableStatus = sc.nextLine();

        MenuDto menu = new MenuDto();
        menu.setMenuName(name);
        menu.setMenuPrice(Integer.parseInt(price));
        menu.setOrderableStatus(orderableStatus.toUpperCase());

        int insertResult = new MenuService().insertMenu(menu);

        if (insertResult > 0) {
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }
    }
}

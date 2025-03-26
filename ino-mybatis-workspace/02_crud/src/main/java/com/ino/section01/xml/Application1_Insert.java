package com.ino.section01.xml;

import com.ino.dto.MenuDto;

import java.util.List;
import java.util.Scanner;

public class Application1_Insert {
    public static void main(String[] args) {
        // menu insert

        // menu info input(view역할이나, 여기선 그냥 함)
//        Scanner sc = new Scanner(System.in);
//        System.out.println("menu name: ");
//        String name = sc.nextLine();
//        System.out.println("menu price: ");
//        String price = sc.nextLine();
//        System.out.println("cate num: ");
//        String category = sc.nextLine();
//        System.out.println("orderable: ");
//        String orderable = sc.nextLine().toUpperCase();

        // 데이터 가공 처리 및 DTO에 담기 (controller)
//        MenuDto menu = new MenuDto(name, Integer.parseInt(price), Integer.parseInt(category), orderable);
        MenuService menuService = new MenuService();
//        menuService.insertMenu(menu);
        List<MenuDto> list = menuService.selectAllMenu();
        for(MenuDto menuDto : list) {
            System.out.println(menuDto.toString());
        }
    }
}

package com.younggalee.run;

import com.younggalee.dto.MenuDto;
import com.younggalee.service.MenuService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 검색기능 - 사용자에게 검색 조건(메뉴명 또는 카테고리명)과 검색어 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                1. 메뉴명으로 키워드 검색
                2. 카테고리명으로 검색
                >> 입력 : """);
        String condition = sc.nextInt() == 1 ? "name" : "category";
        sc.nextLine();
        System.out.print("검색어 : ");
        String value = sc.nextLine();


        // controller
        Map<String, String> searchMap = new HashMap<>(); // {}
        searchMap.put("condition", condition); // {condition:"name|category"}
        searchMap.put("value", value); // {condition:"name|category", value:"xxxx"}

        List<MenuDto> searchList1 = new MenuService().selectMenuByNameOrCategory1(searchMap);
        for (MenuDto menu : searchList1) {
            System.out.println(menu);
        }
        System.out.println("========================================================");

        List<MenuDto> searchList2 = new MenuService().selectMenuByNameOrCategory2(searchMap);
        for (MenuDto menu : searchList2) {
            System.out.println(menu);
        }
    }
}

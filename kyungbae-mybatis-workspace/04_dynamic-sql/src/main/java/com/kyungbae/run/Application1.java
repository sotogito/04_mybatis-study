package com.kyungbae.run;

import com.kyungbae.dto.MenuDto;
import com.kyungbae.service.MenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 검색기능 - 검색조건(메뉴명, 카테고리명) / 검색어 입력받기

        // view
        System.out.print("""
                1. 메뉴명으로 키워드 검색
                2. 카테고리명으로 검색
                >> 입력:""");
        String condition = sc.nextInt() == 1 ? "name" : "category";
        sc.nextLine();

        System.out.print(">> 검색어:");
        String value = sc.nextLine();

        // controller
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("condition", condition);
        searchMap.put("value", value);

        List<MenuDto> searchList1 = new MenuService().selectMenuByNameOrCategory1(searchMap);
        for (MenuDto menu : searchList1) {
            System.out.println(menu);
        }

        List<MenuDto> searchList2 = new MenuService().selectMenuByNameOrCategory2(searchMap);
        searchList2.forEach(System.out::println);
    }
}

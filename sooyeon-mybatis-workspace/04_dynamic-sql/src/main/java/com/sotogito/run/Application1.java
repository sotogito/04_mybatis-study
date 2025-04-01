package com.sotogito.run;

import com.sotogito.dto.MenuDto;
import com.sotogito.service.MenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /// 검색기능 - 검색조건을 입력 받아서 메뉴명or카테고리명으로 입력받기

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                1. 메뉴명으로 키워드 검색
                2. 카테고리명으로 검색
                >>입력:""");
        String condition = switch (Integer.parseInt(sc.nextLine())) {
                                        case 1 -> "name";
                                        case 2 -> "category";
                                        default -> null;
                                    };

        System.out.println("검색어");
        String searchValue = sc.nextLine();

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("condition", condition);
        searchMap.put("value", searchValue);

        List<MenuDto> searchList1 = new MenuService().selectMenuByNameOrCategory1(searchMap);
        searchList1.forEach(System.out::println);


        List<MenuDto> searchList2 = new MenuService().selectMenuByNameOrCategory2(searchMap);
        searchList1.forEach(System.out::println);
    }
}

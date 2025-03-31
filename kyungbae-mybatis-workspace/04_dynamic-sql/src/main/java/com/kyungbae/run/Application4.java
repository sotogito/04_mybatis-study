package com.kyungbae.run;

import com.kyungbae.dto.MenuDto;
import com.kyungbae.service.MenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application4 {
    public static void main(String[] args) {

        // 검색 조건(메뉴명, 카테고리, 둘다, 검색사용x) 입력받고 검색어 입력받아 요청
        Scanner sc = new Scanner(System.in);

        System.out.print("검색조건 입력(name,category,both,none):");
        String condition = sc.nextLine();

        Map<String, Object> searchMap = new HashMap<>();
        if ("name".equals(condition)) {
            System.out.print("검색할 메뉴명:");
            searchMap.put("name", sc.nextLine());
        } else if ("category".equals(condition)) {
            System.out.print("검색할 카테고리번호:");
            searchMap.put("category", sc.nextLine());
        } else if ("both".equals(condition)) {
            System.out.print("검색할 메뉴명:");
            searchMap.put("name", sc.nextLine());
            System.out.print("검색할 카테고리번호:");
            searchMap.put("category", sc.nextLine());
        }

        List<MenuDto> list = new MenuService().selectMenuByNameOrCategory3(searchMap);
        for (MenuDto menuDto : list) {
            System.out.println(menuDto);
        }
    }
}

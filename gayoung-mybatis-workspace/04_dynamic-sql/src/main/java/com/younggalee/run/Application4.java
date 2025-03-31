package com.younggalee.run;

import com.younggalee.dto.MenuDto;
import com.younggalee.service.MenuService;

import java.util.*;

public class Application4 {
    public static void main(String[] args) {
        // 검색조건(메뉴명만, 카테로기명, 둘다, 검색사용X) 입력받고 검색어 입력받아 요청
        Scanner sc = new Scanner(System.in);
        System.out.print("검색조건입력 (name, category, both, none) : ");
        String condition = sc.nextLine();

        Map<String, Object> searchMap = new HashMap<>();
        if("name".equals(condition)){
            System.out.println("검색할 메뉴명 : ");
            searchMap.put("name", sc.nextLine());
        } else if("category".equals(condition)) {
            System.out.println("검색할 카테고리번호 : ");
            searchMap.put("category", sc.nextInt());
        } else if ("both".equals(condition)) {
            System.out.println("검색할 메뉴명 : ");
            searchMap.put("name", sc.nextLine());

            System.out.println("검색할 카테고리번호 : ");
            searchMap.put("category", sc.nextInt());
        }
        List<MenuDto> list = new MenuService().selectMenuByNameOrCategory3(searchMap);
        for (MenuDto menu : list){
            System.out.println(menu);
        }
        
        
    }
}

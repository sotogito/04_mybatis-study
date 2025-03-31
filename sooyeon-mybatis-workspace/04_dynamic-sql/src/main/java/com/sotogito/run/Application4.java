package com.sotogito.run;

import com.sotogito.dto.MenuDto;
import com.sotogito.service.MenuService;

import java.util.*;

public class Application4 {
    public static void main(String[] args) {
        /// 검색 조건 입력받고 검색어입력받아 요청
        /// 메뉴묭? 카테고리명? 둘다? 아무것도?

        Scanner sc = new Scanner(System.in);

        System.out.println("검색 조건을 입력하라(name, category, both, not");
        String condition = sc.nextLine();

        Map<String, Object> searchMap = new HashMap<String, Object>();

        if("name".equals(condition)) {
            System.out.println("검색할 메뉴명 : ");
            searchMap.put("name",sc.nextLine());

        }else if("category".equals(condition)) {
            System.out.println("검색할 카테고리 번호");
            searchMap.put("category",Integer.parseInt(sc.nextLine()));

        }else if("both".equals(condition)) {
            System.out.println("검색할 매뉴명,카테고리번호");
            searchMap.put("name",sc.nextLine());
            searchMap.put("category",Integer.parseInt(sc.nextLine()));
        }

        List<MenuDto> result = new MenuService().selectMenuByNameOrCategory3(searchMap);
        result.forEach(System.out::println);



    }
}

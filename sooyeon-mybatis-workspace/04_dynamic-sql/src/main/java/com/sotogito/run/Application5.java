package com.sotogito.run;

import com.sotogito.dto.MenuDto;
import com.sotogito.service.MenuService;

import java.util.*;

public class Application5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("변경할 메뉴번호, 메뉴명, 카테고리 번호(선택), 판매여부(선택)");
        int menuCode = Integer.parseInt(sc.nextLine());
        String menuName = sc.nextLine();
        String category = sc.nextLine();
        String orderable  = sc.nextLine().toUpperCase();

        Map<String, Object> map = Map.of(
                "code",menuCode
                ,"name",menuName
                ,"category",category
                ,"orderable",orderable
        );

        int updateResult = new MenuService().updateMenu(map);

        if(updateResult == 1){
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }
    }

}

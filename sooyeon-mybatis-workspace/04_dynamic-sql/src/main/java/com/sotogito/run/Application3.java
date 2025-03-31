package com.sotogito.run;

import com.sotogito.dto.MenuDto;
import com.sotogito.service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        /// 사용자에게 검색기능 사용 여부 입력받기
        /// 사용O => 검색할 메뉴번호 입력받기
        /// 사용X => 전테 조회

        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기능 사용? 예 아니오");

        int menuCode = 0;
        if("예".equals(sc.nextLine())){
            System.out.println("검색할 메뉴 번호");
            menuCode = Integer.parseInt(sc.nextLine());
        }
        //아닐 경우는 0

        List<MenuDto> list = new MenuService().selectMenuByCodeOrSearchAll(menuCode);
        list.forEach(System.out::println);
    }
}

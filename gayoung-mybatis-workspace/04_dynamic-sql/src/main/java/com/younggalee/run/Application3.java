package com.younggalee.run;

import com.younggalee.dto.MenuDto;
import com.younggalee.service.MenuService;

import java.util.Scanner;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        //사용자에게 검색기능 사용여부를 묻고
        // Y >> 검색할 메뉴번호를 입력받을 것임
        // N >> 전체조회

        Scanner sc = new Scanner(System.in);
        System.out.print("""
                검색기능을 사용하시겠습니까?
                (예/아니오)""");

        int menuCode = 0;
        if ("예".equals(sc.nextLine())){ // 요구되는 값을 먼저 작성하는게 좋음 (입력이 null일 경우 널포인트예외발생하기 때문)
            System.out.print("\n 검색할 메뉴번호를 입력하세요");
            menuCode = sc.nextInt();
        }
        // menuCode = 0|검색할메뉴번호
        List<MenuDto> list = new MenuService().selectMenuByCodeOrSearchAll(menuCode);
        for (MenuDto menu : list) {
            System.out.println(menu);
        }
    }
}

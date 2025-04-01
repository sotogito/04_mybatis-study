package com.kyungbae.run;

import com.kyungbae.dto.MenuDto;
import com.kyungbae.service.MenuService;

import java.util.List;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        // 검색기능 사용여부 입력받기
        // 사용하기 -> 검색할 메뉴번호 입력
        // 사용안하기 -> 전체 조회

        Scanner sc = new Scanner(System.in);

        System.out.print("검색기능을 사용하시겠습니까 (예/아니오):");

        int menuCode = 0;
        if ("예".equals(sc.nextLine())) {
            System.out.print("검색할 메뉴번호:");
            menuCode = sc.nextInt();
        }

        List<MenuDto> list = new MenuService().selectMenuByCodeOrSearchAll(menuCode);
        for (MenuDto menu : list) {
            System.out.println(menu);
        }
    }
}

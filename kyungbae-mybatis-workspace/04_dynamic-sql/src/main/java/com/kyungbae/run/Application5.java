package com.kyungbae.run;

import com.kyungbae.service.MenuService;

import java.util.Map;
import java.util.Scanner;

public class Application5 {
    public static void main(String[] args) {

        // 정보 수정
        Scanner sc = new Scanner(System.in);

        System.out.print("변경할 메뉴번호:");
        int code = sc.nextInt();
        sc.nextLine();

        System.out.print("수정할 메뉴명:");
        String name = sc.nextLine();
        System.out.print("수정할 카테고리번호:");
        String categoryCode = sc.nextLine();
        System.out.print("수정할 판매가능여부:");
        String orderable = sc.nextLine().toUpperCase();

        Map<String, Object> map = Map.of("code", code, "name", name, "category", categoryCode, "orderable", orderable);

        int result = new MenuService().updateMenu(map);
        if (result > 0) {
            System.out.println("수정 성공");
        } else {
            System.out.println("수정 실패");
        }
    }
}

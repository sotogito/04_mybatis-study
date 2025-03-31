package com.younggalee.run;

import com.younggalee.service.MenuService;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Application5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 메뉴번호(필수) : ");
        int code = sc.nextInt();
        sc.nextLine();

        System.out.println("수정할 메뉴명(선택) : ");
        String name = sc.nextLine();
        System.out.println("수정할 카테고리번호(선택): ");
        String category = sc.nextLine();
        System.out.println("수정할 판매여부(선택) : ");
        String orderable = sc.nextLine().toUpperCase();

        Map<String, Object> map = Map.of("code", code, "name", name, "category", category, "orderable", orderable);
        int result = new MenuService().updateMenu(map);
        if (result > 0){
            System.out.println("수정 성공");
        } else {
            System.out.println("수정 실패");
        }
    }
}

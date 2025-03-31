package com.kyungbae.section01.xml;

import java.util.Scanner;

public class Application3_Delete {
    public static void main(String[] args) {
        // 삭제할 메뉴 번호 입력 (View)
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 번호 입력: ");
        String code = sc.nextLine();

        // controller
        int result = new MenuService().deleteMenu(Integer.parseInt(code));

        if (result > 0) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }
}

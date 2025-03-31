package com.younggalee.run;

import com.younggalee.service.MenuService;

import java.util.List;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 여러 메뉴 일괄 삭제하기
        List<Integer> deleteMenuCodes = new ArrayList<>(); // 삭제할 메뉴번호들 담을 예정

        while (true) {
            System.out.print("삭제할 메뉴번호: ");
            deleteMenuCodes.add(Integer.parseInt(sc.nextLine()));

            System.out.print("그만 입력하시겠습니까: ");
            if (sc.nextLine().toUpperCase().equals("Y")) {
                break;
            }
        }

        int result = new MenuService().deleteMenu(deleteMenuCodes);

        if (result == deleteMenuCodes.size()) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }
}

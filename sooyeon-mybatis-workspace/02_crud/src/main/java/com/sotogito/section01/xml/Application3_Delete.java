package com.sotogito.section01.xml;

import com.sun.source.tree.TryTree;

import java.util.Scanner;

public class Application3_Delete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 메뉴 코드를 입력하세요");
        String menuCode = sc.nextLine();

        int deleteResult = 0;
        try {
            deleteResult = new MenuService().deleteMenu(Integer.parseInt(menuCode));
        } catch (NumberFormatException e) {
            System.out.println("숫자로");
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        if (deleteResult > 0) {
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }
    }

}

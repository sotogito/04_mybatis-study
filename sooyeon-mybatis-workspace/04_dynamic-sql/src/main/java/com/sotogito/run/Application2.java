package com.sotogito.run;

import com.sotogito.service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        ///  여러 메뉴 일괄 삭제하기
        Scanner sc = new Scanner(System.in);
        List<Integer> deleteMenuCodes = new ArrayList<Integer>();

        while (true){
            System.out.println("삭제할 메뉴 번호");
            deleteMenuCodes.add(Integer.parseInt(sc.nextLine()));

            System.out.println("그만 입력?");
            if(sc.nextLine().equalsIgnoreCase("Y")){
                break;
            }
        }
        int result = new MenuService().deleteMenu(deleteMenuCodes);

        if(result == deleteMenuCodes.size()){
            System.out.println("성공");
        }else {
            System.out.println("실패");
        }
    }
}

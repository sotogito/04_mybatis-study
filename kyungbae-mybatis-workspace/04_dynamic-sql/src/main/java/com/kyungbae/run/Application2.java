package com.kyungbae.run;

import com.kyungbae.service.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 여러 메뉴 일괄 삭제
        List<Integer> deleteMenuCode = new ArrayList<>(); // 삭제할 메뉴변호를 담는 배열

        while(true){
            System.out.print("삭제할 메뉴번호:");
            deleteMenuCode.add(Integer.parseInt(sc.nextLine()));

            System.out.print("추가로 입력하시겠습니까 (y/n):");
            if(sc.nextLine().toUpperCase().equals("N")){
                break;
            }
        }

        int result = new MenuService().deleteMenu(deleteMenuCode);
        if (result == deleteMenuCode.size()) {
            System.out.println(result + "개 메뉴 삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
    }
}

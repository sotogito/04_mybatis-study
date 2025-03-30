package com.minkook.section01.xml;

import java.util.Scanner;

public class Application3_Delete {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴번호: ");
        int num  = sc.nextInt();
        sc.nextLine();
        
        int result = new MenuService().deleteMenu(num);
        
        if(result > 0){
            System.out.println("삭제성공");
        }else {
            System.out.println("삭제실패");
        }
        
    }
}

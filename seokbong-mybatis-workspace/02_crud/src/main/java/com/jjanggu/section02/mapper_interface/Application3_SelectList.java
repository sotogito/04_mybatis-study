package com.jjanggu.section02.mapper_interface;

import com.jjanggu.dto.MenuDto;

import java.util.List;
import java.util.Scanner;

public class Application3_SelectList {
    public static void main(String[] args) {

        // 카테고리명을 입력받아 해당 카테고리의 메뉴 목록 조회
        Scanner sc = new Scanner(System.in);
        System.out.print("카테고리명: ");
        String category = sc.nextLine();

        List<MenuDto> list = new MenuService().selectMenuByCategory(category);

        if(list.isEmpty()){
            System.out.println("검색된 결과가 없습니다");
        }else {
            list.forEach(System.out::println);
        }
    }
}

package com.kyungbae.section02.mapper_interface;

import com.kyungbae.dto.MenuDto;

import java.util.List;
import java.util.Scanner;

public class Application3_SelectList {
    public static void main(String[] args) {

        // 카테고리명을 입력받아 해당 카테고리의 메뉴 목록 조회
        Scanner sc = new Scanner(System.in);
        System.out.print("카테고리명 입력: ");
        String category = sc.nextLine();

        List<MenuDto> menuList = new MenuService().selectMenuByCategory(category);
        menuList.forEach(System.out::println);

    }
}

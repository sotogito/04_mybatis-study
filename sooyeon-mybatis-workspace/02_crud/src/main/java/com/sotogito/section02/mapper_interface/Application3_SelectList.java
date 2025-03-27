package com.sotogito.section02.mapper_interface;

import com.sotogito.dto.MenuDto;

import java.util.List;
import java.util.Scanner;

public class Application3_SelectList {
    public static void main(String[] args) {

        /// 카테고리 입력받아 해당 카테고리의 메뉴 목록 조회
        Scanner sc = new Scanner(System.in);
        System.out.println("카테고리명 :");
        String category = sc.nextLine();

        List<MenuDto> result = new MenuService().selectMenuListByCategoryName(category);

        result.forEach(System.out::println);

        /**
         * 1, 인터페이스 매퍼를 mapper.xml에 namesplace에 지정해둔다.
         * 2. 서비스에서 SqlSession을 생성한 뒤 인터페이스 매퍼를 가쟈온다.
         * 3. 인터페이스 매퍼에서ㅏ 사용한 메서드 실행
         */
    }
}

package com.johnth.run;

import com.johnth.dto.MenuDto;
import com.johnth.service.MenuService;

import java.util.List;

public class Application2 {
    public static void main(String[] args) {

        // 메뉴 목록 조회 이때 카테고리 정보도 같이 조회
        List<MenuDto> list = new MenuService().testResultMapAssociation();
        for (MenuDto menu : list) {
            System.out.println(menu);
        }

    }
}

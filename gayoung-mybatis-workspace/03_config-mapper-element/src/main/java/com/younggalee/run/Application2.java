package com.younggalee.run;

import com.younggalee.dto.MenuDto;
import com.younggalee.service.MenuService;

import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        // 메뉴 목록 조회 이때 카테고리 정보 같이 조회
        List<MenuDto> list = new MenuService().testResultMapAssociation();
        for (MenuDto menu : list){
            System.out.println(menu);
        }
    }
}

package com.minkook.section01.xml;

import com.minkook.dto.MenuDto;

import java.util.List;
import java.util.Scanner;

public class Application4_Select {
    public static void main(String [] args){
        List<String> list = new MenuService().selectMenuNameList();
        for(String s : list){
            System.out.println(s);
        }

        System.out.println("===================================");

        //2 주문가능한 전체메뉴(메뉴번호,메뉴명,가격,카테고리,주문가능여부) 조회
        List<MenuDto> meneList = new MenuService().selectOrderableMenuList();

        for(MenuDto menuDto : meneList){
            System.out.println(menuDto);
        }


    }
}

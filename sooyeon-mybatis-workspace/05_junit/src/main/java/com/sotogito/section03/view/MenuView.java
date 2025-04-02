package com.sotogito.section03.view;

import com.sotogito.section03.controller.MenuController;
import com.sotogito.section03.dto.MenuDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuView {
    private Scanner sc = new Scanner(System.in);

    private MenuController menuController = new MenuController();

    public void mainMenuView() {
        while (true) {
            System.out.println("""
                    =======================
                    1. 전체 메뉴 목록 조회
                    2. 메뉴 번호로 메뉴 조회
                    3. 카테고리 코드로 목록 조회
                    4. 하위 카테고리 목록 조회
                    5. 신규 메뉴등록
                    6. 기존 메뉴 수정
                    7. 기존 메뉴 삭제
                    0. 프로그램 종료
                    =======================
                    >>> 입력:""");
            String menu = sc.nextLine();

            switch (menu) {
                case "1": menuController.selectMenuList(); break;
                case "2": menuController.selectMenuByMenuCode(inputCode("메뉴코드")); break;
                case "3": menuController.selectMenuListByCategoryCode(inputCode("카테고리코드")); break;
                case "4": menuController.selectCategoryList();  break;
                case "5": registMenuForm(); break;
                case "6": modifyMenuForm(); break;
                case "7": menuController.removeMenu(inputCode("메뉴코드"));break;
                case "0": return;
            }

        }
    }

    private void registMenuForm() {
        System.out.println("등록할 메뉴 정보를 작성해주세요");
        System.out.println("메뉴명, 메뉴가격, 카테고리코드, 주문가능여부");
        String menuName = sc.nextLine();
        String menuPrice = sc.nextLine();
        String categoryCode = sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String, String> requestParams = Map.of(
                  "menuName", menuName
                , "menuPrice", menuPrice
                , "categoryCode", categoryCode
                , "orderableStatus", orderableStatus
        );

        menuController.registMenu(requestParams);
    }

    private void modifyMenuForm() {
        System.out.println("등록할 메뉴 정보를 작성해주세요");
        System.out.println("메뉴 코드 입력");
        String menuCode = sc.nextLine();
        System.out.println("메뉴명, 메뉴가격, 카테고리코드, 주문가능여부");
        String menuName = sc.nextLine();
        String menuPrice = sc.nextLine();
        String categoryCode = sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String, String> requestParams = Map.of(
                "menucode", menuCode
                , "menuName", menuName
                , "menuPrice", menuPrice
                , "categoryCode", categoryCode
                , "orderableStatus", orderableStatus
        );

        menuController.modifyMenuForm(requestParams);
    }

    public String inputCode(String type){
        System.out.printf("%s 입력", type);
        return sc.nextLine();
    }
}

package com.sotogito.section03.controller;

import com.sotogito.section03.dto.MenuDto;
import com.sotogito.section03.service.MenuService;
import com.sotogito.section03.view.ResultView;

import java.util.Map;

public class MenuController {
    private MenuService menuService = new MenuService();

    public void selectMenuList() {
        ResultView.displayMenuList(menuService.selectMenuList());
    }

    public void selectCategoryList() {
        ResultView.displayCategoryList(menuService.selectSubCategoryList());
    }

    public void selectMenuByMenuCode(String menuCode) {
        ResultView.displayMenu(menuService.selectMenuByMenuCode(Integer.parseInt(menuCode)));
    }

    public void selectMenuListByCategoryCode(String categoryCode) {
        ResultView.displayMenuList(menuService.selectMenuListByCategoryCode(Integer.parseInt(categoryCode)));
    }

    public void registMenu(Map<String, String> requestParams) {
        MenuDto menu = MenuDto.builder()
                .menuName(requestParams.get("menuName"))
                .menuPrice(Integer.parseInt(requestParams.get("menuPrice")))
                .categoryCode(Integer.parseInt(requestParams.get("categoryCode")))
                .orderableStatus(requestParams.get("orderableStatus").toUpperCase())
                .build();

        int insertResult = menuService.insertMenu(menu);
        ResultView.displayResult("메뉴등록", insertResult);
    }

    public void modifyMenuForm(Map<String, String> requestParams) {
        MenuDto menu = MenuDto.builder()
                .menuCode(Integer.parseInt(requestParams.get("menuCode")))
                .menuName(requestParams.get("menuName"))
                .menuPrice(Integer.parseInt(requestParams.get("menuPrice")))
                .categoryCode(Integer.parseInt(requestParams.get("categoryCode")))
                .orderableStatus(requestParams.get("orderableStatus").toUpperCase())
                .build();

        int modifyResult = menuService.updateMenu(menu);
    }

    public void removeMenu(String menuCode) {
        int removeResult = menuService.deleteMenu(Integer.parseInt(menuCode));
        ResultView.displayResult("메뉴삭제", removeResult);
    }
}

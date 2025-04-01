package com.jjanggu.section03.dao;

import com.jjanggu.section03.dto.CategoryDto;
import com.jjanggu.section03.dto.MenuDto;

import java.util.List;

public interface MenuMapper {

    List<MenuDto> selectAllMenu();
    MenuDto selectMenuByMenuCode(int code);
    List<MenuDto> selectMenuByCategoryCode(int code);
    List<CategoryDto> selectAllSubCategory();
    int insertMenu(MenuDto menu);
    int updateMenu(MenuDto menu);
    int deleteMenu(int code);


}

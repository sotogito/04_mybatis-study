package com.sotogito.section03.dao;

import com.sotogito.section03.dto.CategoryDto;
import com.sotogito.section03.dto.MenuDto;

import java.util.List;

public interface MenuMapper {

    List<MenuDto> selectAllMenu();

    MenuDto selectMenuByMenuCode(int menuCode);

    List<MenuDto> selectMenuByCategoryCode(int categoryCode);

    List<CategoryDto> selectAllSubCategory();

    int insertMenu(MenuDto menuDto);

    int updateMenuByMenuCode(MenuDto menuDto);

    int deleteMenuByMenuCode(int menuCode);

}

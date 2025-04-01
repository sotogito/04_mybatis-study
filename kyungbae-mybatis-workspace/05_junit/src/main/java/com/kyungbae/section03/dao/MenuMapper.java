package com.kyungbae.section03.dao;

import com.kyungbae.section03.dto.CategoryDto;
import com.kyungbae.section03.dto.MenuDto;

import java.util.List;

public interface MenuMapper {

    List<MenuDto> selectAllMenu();

    MenuDto selectMenuByMenuCode(int menuCode);

    List<MenuDto> selectMenuByCategoryCode(int categoryCode);

    List<CategoryDto> selectCategory();

    int insertMenu(MenuDto menu);

    int updateMenu(MenuDto menu);

    int deleteMenu(int menuCode);
}

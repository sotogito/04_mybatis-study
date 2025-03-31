package com.ibe6.section02.mapper_interface;

import com.ibe6.dto.MenuDto;

import java.util.List;

public interface MenuMapper {

    int insertMenu(MenuDto menu);
    MenuDto selectMenuByCode(int code);
    int selectMenuCountByPrice(int price);
    List<MenuDto> selectMenuByCategory(String category);
    // 왜이것만?????
}

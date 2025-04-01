package com.kyungbae.section02.mapper_interface;

import com.kyungbae.dto.MenuDto;

import java.util.List;

public interface MenuMapper {

    int  insertMenu(MenuDto menu);
    MenuDto selectMenuByCode(int code);
    int selectMenuByPrice(int price);
    List<MenuDto> selectMenuByCategory(String category);
}

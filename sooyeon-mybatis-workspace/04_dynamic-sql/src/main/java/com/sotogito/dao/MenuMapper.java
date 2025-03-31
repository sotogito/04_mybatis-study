package com.sotogito.dao;

import com.sotogito.dto.MenuDto;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    List<MenuDto> selectMenuByNameOrCategory1(Map<String, String> searchMap);

    List<MenuDto> selectMenuByNameOrCategory2(Map<String, String> searchMap);

    //int deleteMenu(List<Integer> deleteMenuCodes);
    int deleteMenu(Map<String, Object> map);

    List<MenuDto> selectMenuByCodeOrSearchAll(int menuCode);

    List<MenuDto> selectMenuByNameOrCategory3(Map<String, Object> searchMap);

    int updateMenu(Map<String, Object> map);
}

package com.younggalee.dao;

import com.younggalee.dto.MenuDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface MenuMapper {

    // <if> 테스트
    List<MenuDto> selectMenuByNameOrCategory1(Map<String, String> searchMap);

    // <choose> <when> <otherwise> 테스트
    List<MenuDto> selectMenuByNameOrCategory2(Map<String, String> searchMap);

//    int deleteMenu(List<Integer> deleteMenuCodes);
    int deleteMenu(Map<String, Object> map); // 리스트가 담겨있는 맵

    // <where> test
    List<MenuDto> selectMenuByCodeOrSearchAll(int menuCode);

    //
    List<MenuDto> selectMenuByNameOrCategory3(Map<String, Object> searchMap);

    int updateMenu(Map<String, Object> map);
}

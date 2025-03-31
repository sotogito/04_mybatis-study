package com.kyungbae.dao;

import com.kyungbae.dto.MenuDto;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    // if 테스트
    List<MenuDto> selectMenuByNameOrCategory1(Map<String, String> searchMap);
    // choose 테스트
    List<MenuDto> selectMenuByNameOrCategory2(Map<String, String> searchMap);

    // foreach test
    // list를 전달하는 case
    // int deleteMenu(List<Integer> deleteMenuCode);

    // list가 담겨있는 map을 전달하는 case
    int deleteMenu(Map<String, Object> map);


    List<MenuDto> selectMenuByCodeOrSearchAll(int menuCode);

    List<MenuDto> selectMenuByNameOrCategory3(Map<String, Object> searchMap);

    int updateMenu(Map<String, Object> map);
}

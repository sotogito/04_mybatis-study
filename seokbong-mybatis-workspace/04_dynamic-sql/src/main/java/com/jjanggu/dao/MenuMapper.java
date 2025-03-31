package com.jjanggu.dao;

import com.jjanggu.dto.MenuDto;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    // <if> 테스트
    List<MenuDto> selectMenuByNameOrCategory1(Map<String, String> searchMap);
    // <choose>, <when>, <otherwise> 테스트
    List<MenuDto> selectMenuByNameOrCategory2(Map<String, String> searchMap);

    // <foreach> 테스트
    //int deleteMenu(List<Integer> deleteMenuCodes); // List를 곧바로 전달하는 case
    int deleteMenu(Map<String, Object> map); // List가 담겨있는 map을 전달하는 case

    // <where> 테스트
    List<MenuDto> selectMenuByCodeOrSearchAll(int menuCode);
    //
    List<MenuDto> selectMenuByNameOrCategory3(Map<String, Object> searchMap);

    int updateMenu(Map<String, Object> map);
}

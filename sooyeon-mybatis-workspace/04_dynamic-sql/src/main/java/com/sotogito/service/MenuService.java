package com.sotogito.service;

import com.sotogito.dao.MenuMapper;
import com.sotogito.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.sotogito.common.Template.getSqlSession;

public class MenuService {
    private MenuMapper menuMapper;

    public List<MenuDto> selectMenuByNameOrCategory1(Map<String, String> searchMap) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> list = menuMapper.selectMenuByNameOrCategory1(searchMap);

        sqlSession.close();
        return list;
    }

    public List<MenuDto> selectMenuByNameOrCategory2(Map<String, String> searchMap) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> list = menuMapper.selectMenuByNameOrCategory2(searchMap);

        sqlSession.close();
        return list;
    }

    public int deleteMenu(List<Integer> deleteMenuCodes) {
        try (SqlSession sqlSession = getSqlSession()) {
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            //int result = menuMapper.deleteMenu(deleteMenuCodes); /// 리스트 바로 전달
            Map<String, Object> map = new HashMap<>();
            map.put("deleteMenuCodes", deleteMenuCodes);

            int result = menuMapper.deleteMenu(map);

            if (result == deleteMenuCodes.size()) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }

            return result;
        }
    }


    public List<MenuDto> selectMenuByCodeOrSearchAll(int menuCode) {
        try(SqlSession sqlSession = getSqlSession()) {
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            List<MenuDto> result = menuMapper.selectMenuByCodeOrSearchAll(menuCode);

            return result;
        }
    }

    public List<MenuDto> selectMenuByNameOrCategory3(Map<String, Object> searchMap) {
        try(SqlSession sqlSession = getSqlSession()) {
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            List<MenuDto> result = menuMapper.selectMenuByNameOrCategory3(searchMap);

            return result;
        }
    }

    public int updateMenu(Map<String, Object> map) {
        try (SqlSession sqlSession = getSqlSession()) {
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            int result = menuMapper.updateMenu(map);

            if(result == 1){
                sqlSession.commit();
            }else {
                sqlSession.rollback();
            }

            return result;
        }
    }
}

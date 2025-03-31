package com.kyungbae.service;

import com.kyungbae.dao.MenuMapper;
import com.kyungbae.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kyungbae.common.Template.getSqlSession;

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

    public int deleteMenu(List<Integer> deleteMenuCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        // list를 곧바로 전달하는 case
        // int result = menuMapper.deleteMenu(deleteMenuCode);
        Map<String, Object> map = new HashMap<>();
        map.put("deleteMenuCode", deleteMenuCode);

        int result = menuMapper.deleteMenu(map);

        if (result == deleteMenuCode.size()) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public List<MenuDto> selectMenuByCodeOrSearchAll(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> list = menuMapper.selectMenuByCodeOrSearchAll(menuCode);
        sqlSession.close();
        return list;
    }

    public List<MenuDto> selectMenuByNameOrCategory3(Map<String, Object> searchMap) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> list = menuMapper.selectMenuByNameOrCategory3(searchMap);
        sqlSession.close();
        return list;
    }

    public int updateMenu(Map<String, Object> map) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(map);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}

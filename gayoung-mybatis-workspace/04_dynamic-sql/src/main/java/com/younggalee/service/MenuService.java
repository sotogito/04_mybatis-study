package com.younggalee.service;

import com.younggalee.dao.MenuMapper;
import com.younggalee.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.awt.image.MemoryImageSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.younggalee.common.Template.getSqlSession;

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

    // <foreach> 테스트
    public int deleteMenu (List<Integer> deleteMenuCodes){
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        //리스트를 곧바로 전달하는 case
        //int result = menuMapper.deleteMenu(deleteMenuCodes);

        // map에 담아서 리스트를 전달하는 case
        Map<String, Object> map = new HashMap<>();
        map.put("deleteMenuCodes", deleteMenuCodes);

        int result = menuMapper.deleteMenu(map);

        if(result == deleteMenuCodes.size()){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public List<MenuDto> selectMenuByCodeOrSearchAll(int menucode){
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.selectMenuByCodeOrSearchAll(menucode);
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

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}

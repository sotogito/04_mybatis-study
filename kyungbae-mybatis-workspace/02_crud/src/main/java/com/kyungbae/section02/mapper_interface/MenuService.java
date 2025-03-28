package com.kyungbae.section02.mapper_interface;

import com.kyungbae.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.kyungbae.section02.mapper_interface.Template.getSqlSession;

public class MenuService {

    public int insertMenu(MenuDto menu) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public MenuDto selectMenuByCode(int code) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menu = menuMapper.selectMenuByCode(code);
        sqlSession.close();
        return menu;
    }

    public int selectMenuByPrice(int price) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int count = menuMapper.selectMenuByPrice(price);
        sqlSession.close();
        return count;
    }

    public List<MenuDto> selectMenuByCategory(String category) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> menuList = menuMapper.selectMenuByCategory(category);
        sqlSession.close();
        return menuList;
    }
}

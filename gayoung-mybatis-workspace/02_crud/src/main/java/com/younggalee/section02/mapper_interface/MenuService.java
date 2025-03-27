package com.younggalee.section02.mapper_interface;

import com.younggalee.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.younggalee.section02.mapper_interface.Template.getSqlSession;

public class MenuService {
    public int insertMenu(MenuDto menu){
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.insertMenu(menu);
        if(result>0){
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
        // 등록되어있는 mapper 가져오기
        // MenuMapper.class : 메퍼 인터페이스
        MenuDto menu = menuMapper.selectMenuByCode(code);
        if(menu != null){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return menu;
    }
    public int selectMenuCountByPrice(int price) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int count = menuMapper.selectMenuCountByPrice(price);
        sqlSession.close();
        return count;
    }

    public List<MenuDto> selectMenuByCategory(String category) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> list = menuMapper.selectMenuByCategory(category);
        sqlSession.close();
        return list;
    }
}

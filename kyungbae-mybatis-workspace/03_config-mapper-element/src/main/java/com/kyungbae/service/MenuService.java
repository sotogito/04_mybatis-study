package com.kyungbae.service;

import com.kyungbae.dao.MenuMapper;
import com.kyungbae.dto.MenuDto;
import com.kyungbae.dto.OrderDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.kyungbae.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDto> testResultMapExtends1() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.testResultMapExtends1();
        sqlSession.close();
        return list;
    }

    public List<MenuDto> testResultMapExtends2() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.testResultMapExtends2();
        sqlSession.close();
        return list;
    }

    public List<MenuDto> testResultMapAssociation() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.testResultMapAssociation();
        sqlSession.close();
        return list;
    }

    public List<OrderDto> testREsultMapCollection(int orderCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<OrderDto> list = menuMapper.testResultMapCollection(orderCode);
        sqlSession.close();
        return list;
    }

    public MenuDto testSql(int code){
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menu = menuMapper.testSql(code);
        sqlSession.close();
        return menu;
    }

    public int insertCategoryAndMenu(MenuDto menu) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = 0;
        // 1. 카테고리 insert 하고 옴
        int result1 = menuMapper.insertCategory(menu);
        // selectKey를 통해 MenuDto의 categoryCode 값에 방금 생성된 category의 code 값이 들어감

        // 3. 메뉴 insert 하기
        int result2 = menuMapper.insertMenu(menu);

        if (result1 > 0 && result2 > 0) {
            sqlSession.commit();
            result = 1;
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}

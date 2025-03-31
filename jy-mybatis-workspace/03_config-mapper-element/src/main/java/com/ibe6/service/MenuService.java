package com.ibe6.service;

import com.ibe6.dao.MenuMapper;
import com.ibe6.dto.MenuDto;
import com.ibe6.dto.OrderDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ibe6.commom.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDto> testResultMapExtends1(){
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.testResultMapExtends1();
        sqlSession.close();
        return list;
    }

    public List<MenuDto> testResultMapExtends2(){
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.testResultMapExtends2();
        sqlSession.close();
        return list;
    }

    public List<MenuDto> testResultMapAssociation(){
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.testResultMapAssociation();
        sqlSession.close();
        return list;
    }

    public OrderDto testResultMapCollection(int code){
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        OrderDto order = menuMapper.testResultMapCollection(code);
        sqlSession.close();
        return order;
    }

    public MenuDto testSql(int code){
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menu = menuMapper.testSql(code);
        sqlSession.close();
        return menu;
    }

    public int insertCategoryAndMenu(MenuDto menu){

        /*
            서비스로 전달된 최초의 menu 상태
            {
               menuName: 메뉴명,
               menuPrice: 메뉴가격,
               orderableStatus: 주문가능여부,
               categoryCode: 0, // 아직 제대로된 카테고리번호 없음
               category: {
                  categoryName: 카테고리명,
                  refCategoryCode: 상위카테고리번호
               }
            }
         */
        System.out.println("service로 전달된 menu: " + menu);

        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        // 1. 카테고리 insert 하고 옴
        int result1 = menuMapper.insertCategory(menu);
        System.out.println("카테고리 추가후 menu: " + menu);
        /*
            카테고리 추가하고 돌아온 menu 상태
            {
               menuName: 메뉴명,
               menuPrice: 메뉴가격,
               orderableStatus: 주문가능여부,
               categoryCode: xx, // SELECT LAST_INSERT_ID() 의 결과
               category: {
                  categoryName: 카테고리명,
                  refCategoryCode: 상위카테고리번호
               }
            }
         */

        // 2. 메뉴 insert 하기
        int result2 = menuMapper.insertMenu(menu);

        int result = 0;
        if(result1 > 0 && result2 > 0){
            sqlSession.commit();
            result = 1;
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;

    }

}
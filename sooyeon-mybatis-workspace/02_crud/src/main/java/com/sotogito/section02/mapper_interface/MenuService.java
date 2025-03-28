package com.sotogito.section02.mapper_interface;

import com.sotogito.dto.MenuDto;
import com.sotogito.section01.xml.MenuDao;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sotogito.section02.mapper_interface.Template.getSqlSession;

public class MenuService {
    public int insertMenu(MenuDto menu) {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        /**
         * MenuMapper.class를 기준으로
         * 같은 namespace를 가진 mapper.xml을 찾고
         * XML에 있는 <select>, <insert> 등의 id와
         * 인터페이스의 메서드 이름을 연결함
         * 그걸 구현한 프록시(proxy) 객체를 만들어서 리턴함
         *
         * 인터페이스 메서드를 호출하면 내부적으로
         * sqlSession.insert("MenuMapper.insertMenu", menu);
         * 실행
         */

        int result = menuMapper.insertMenu(menu);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result;
    }

    public MenuDto selectMenuByCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDto result = menuMapper.selectMenuByCode(menuCode);

        sqlSession.close();
        return result;
    }

    public int selectMenuCountBelowPrice(int menuPrice){
        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.selectMenuCountBelowPrice(menuPrice);

        sqlSession.close();
        return result;
    }

    public List<MenuDto> selectMenuListByCategoryName(String categoryName) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> menuList = menuMapper.selectMenuListByCategoryName(categoryName);

        sqlSession.close();
        return menuList;
    }
}

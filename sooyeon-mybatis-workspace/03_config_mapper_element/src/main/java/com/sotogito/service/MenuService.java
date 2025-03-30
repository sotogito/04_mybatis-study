package com.sotogito.service;

import com.sotogito.dao.MenuMapper;
import com.sotogito.dto.MenuDto;
import com.sotogito.dto.OrderDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sotogito.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    /// sqlSession는 전역으로 쓰면 안됨, MenuMapper는스레드 안전 전역 선언 무방

    public List<MenuDto> testResultMapExtend1() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> result = menuMapper.testResultMapExtend1();

        sqlSession.close();
        return result;
    }

    public List<MenuDto> testResultMapExtend2() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> result = menuMapper.testResultMapExtend2();

        sqlSession.close();
        return result;
    }

    public List<MenuDto> testResultMapAssociation() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDto> result = menuMapper.testResultMapAssociation();

        sqlSession.close();
        return result;
    }

    public OrderDto testResultMapCollection(int orderCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        OrderDto result = menuMapper.testResultMapCollection(orderCode);

        if (result == null) {
            throw new IllegalArgumentException("존재하지 않는 주문번호입니다.");
        }

        sqlSession.close();
        return result;
    }

    public MenuDto testSql(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDto result = menuMapper.testSql(menuCode);

        sqlSession.close();
        return result;
    }

    public int insertCategoryAndMenu(MenuDto menu) {
        /**
         * 1. 카테고리 insert 하고옴
         * 2. 1번 과정에서 생성된 카테고리 번호 조회
         * 3. 조회된 카테고리 코드로 신규메뉴 추가
         */

        /**
         * 서비스로 전달된 최초의 menu 상태
         * {
         *      menuName
         *      menuPrice
         *      orderableStatus
         *      categoryCode
         *      category : {
         *          categoryName
         *          refCategoryName
         *      }
         * }
         */

        System.out.println("Service로 전달된 menu" + menu);

        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        /// 1. category insert
        int categoryInsertResult = menuMapper.insertCategory(menu);
        /// 카테고리 번호가 menuDto에 set이 되어도 성공 여부를 판별하기 위해 _int타입을 받아와야함 - insert

        /**
         * 카테고리 추가하고 돌아온 menu 의 상태
         *          * {
         *          *      menuName
         *          *      menuPrice
         *          *      orderableStatus
         *          *      categoryCode // SELECT LAST_INSERT_ID()
         *          *      category : {
         *          *          categoryName
         *          *          refCategoryName
         *          *      }
         *          *
         */

        /// MenuDto의 categorycode가 내부적으로 set되었다면 바로 똑같은 MenuDto를 넘겨서 insert해주면 됨
        int insertMenuResult = menuMapper.insertMenu(menu);

        int result = 0;
        if(categoryInsertResult >0 && insertMenuResult >0) {
            result = 1;
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result;
    }
}

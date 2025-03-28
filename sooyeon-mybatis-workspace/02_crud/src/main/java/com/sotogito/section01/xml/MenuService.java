package com.sotogito.section01.xml;

import com.sotogito.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sotogito.section01.xml.Template.getSqlSession;

public class MenuService {
    private MenuDao menuDao = new MenuDao();

    public int insertMenu(MenuDto menu) {
        SqlSession sqlSession = getSqlSession();

        int result =  menuDao.insertMenu(sqlSession,menu);
        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result;
    }

    public int updateMenu(MenuDto menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDao.updateMenu(sqlSession,menu);
        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result;
    }

    public int deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        int result = 0;
        try {
            result = menuDao.deleteMenu(sqlSession,menuCode);
        } catch (RuntimeException e) {
            throw new RuntimeException("주문처리된 메뉴는 삭제할 수 없습니다.");
        }
        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result;
    }

    public List<String> selectMenuNameList() {
        SqlSession sqlSession = getSqlSession();

        List<String> result = menuDao.selectMenuNameList(sqlSession);

        sqlSession.close();
        return result;
    }

    public List<MenuDto> selectOrderableMenuList() {
        SqlSession sqlSession = getSqlSession();

        List<MenuDto> result = menuDao.selectOrderableMenuList(sqlSession);

        sqlSession.close();
        return result;
    }

    public int selectOrderableMenuCount() {
        SqlSession sqlSession = getSqlSession();

        int result = menuDao.selectOrderableMenuCount(sqlSession);

        sqlSession.close();
        return result;
    }

    public MenuDto selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        MenuDto result = menuDao.selectMenuByMenuCode(sqlSession,menuCode);

        sqlSession.close();
        return result;
    }
}

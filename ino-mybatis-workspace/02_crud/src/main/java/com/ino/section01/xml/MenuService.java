package com.ino.section01.xml;

import com.ino.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ino.section01.xml.Template.getSqlSession;

public class MenuService {
    MenuDao menuDao = new MenuDao();

    public int insertMenu(MenuDto menuDto) {
        SqlSession sqlSession = getSqlSession();
        int result = menuDao.insertMenu(sqlSession, menuDto);
        sqlSession.close();
        return result;
    }

    public List<MenuDto> selectAllMenu() {
        SqlSession sqlSession = getSqlSession();
        return menuDao.selectAllMenu(sqlSession);
    }
}

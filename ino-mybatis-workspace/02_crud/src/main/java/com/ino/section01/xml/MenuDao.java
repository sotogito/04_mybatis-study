package com.ino.section01.xml;

import com.ino.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDao {

    public int insertMenu(SqlSession sqlSession, MenuDto menuDto) {
        return sqlSession.insert("Menu.insert", menuDto);
    }


    public List<MenuDto> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("Menu.selectList");
    }
}

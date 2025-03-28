package com.kyungbae.section01.xml;

import com.kyungbae.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDao {

    public int insertMenu(SqlSession sqlSession, MenuDto menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDto menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int code) {
        return sqlSession.delete("MenuMapper.deleteMenu", code);
    }

    public List<String> selectMenuNameList(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectMenuNameList");
    }

    public List<MenuDto> selectOrderableMenuList(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectOrderableMenuList");
    }

    public int selectOrderableMenuCount(SqlSession sqlSession) {
        return sqlSession.selectOne("selectOrderableMenuCount");
    }

    public MenuDto selectMenuByMenuCode(SqlSession sqlSession, int menuCode) {
        return sqlSession.selectOne("selectMenuByMenuCode", menuCode);
    }
}

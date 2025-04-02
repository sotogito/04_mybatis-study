package com.sotogito.section03.service;

import com.sotogito.section03.common.Template;
import com.sotogito.section03.dao.MenuMapper;
import com.sotogito.section03.dto.CategoryDto;
import com.sotogito.section03.dto.MenuDto;
import com.sotogito.section03.view.ResultView;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sotogito.section03.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDto> selectMenuList() {
        try(SqlSession sqlSession = getSqlSession()){
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            return menuMapper.selectAllMenu();
        }
    }

    public List<CategoryDto> selectSubCategoryList(){
        try(SqlSession sqlSession = getSqlSession()){
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            return menuMapper.selectAllSubCategory();
        }
    }

    public MenuDto selectMenuByMenuCode(int menuCode) {
        try(SqlSession sqlSession = getSqlSession()){
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            return menuMapper.selectMenuByMenuCode(menuCode);
        }
    }

    public List<MenuDto> selectMenuListByCategoryCode(int categoryCode) {
        try(SqlSession sqlSession = getSqlSession()){
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            return menuMapper.selectMenuByCategoryCode(categoryCode);
        }
    }

    public int insertMenu(MenuDto menu) {
        try(SqlSession sqlSession = getSqlSession()){
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            int result = 0;
            try {
                result = menuMapper.insertMenu(menu);
                sqlSession.commit();

            } catch (Exception e) {
                sqlSession.rollback();
                e.printStackTrace();
            }

            return result;
        }
    }

    public int updateMenu(MenuDto menu) {
        try(SqlSession sqlSession = getSqlSession()){
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            int result = 0;
            try {
                result = menuMapper.updateMenuByMenuCode(menu);
                sqlSession.commit();
            } catch (Exception e) {
                sqlSession.rollback();
                e.printStackTrace();
            }

            return result;
        }
    }

    public int deleteMenu(int menuCode) {
        try(SqlSession sqlSession = getSqlSession()){
            menuMapper = sqlSession.getMapper(MenuMapper.class);

            int result = 0;
            try {
                menuMapper.deleteMenuByMenuCode(menuCode);
                sqlSession.commit();
            } catch (Exception e) {
                sqlSession.rollback();
                e.printStackTrace();
            }

            return result;
        }
    }
}

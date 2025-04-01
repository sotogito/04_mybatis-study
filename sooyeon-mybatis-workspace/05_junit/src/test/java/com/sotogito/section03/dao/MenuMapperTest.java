package com.sotogito.section03.dao;

import com.sotogito.section03.common.Template;
import com.sotogito.section03.dto.CategoryDto;
import com.sotogito.section03.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuMapperTest {
    private SqlSession sqlSession;
    private MenuMapper menuMapper;

    @BeforeEach
    void setUp() {
         sqlSession = Template.getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    /**
     * given : 어떤 데이터를 가지고
     * when : 어떤 메서드 실행시
     * then : 어떤 결과가 나와야하는지
     */

    @Test
    void selectAllMenu() {
        /// given

        /// when
        List<MenuDto> result = menuMapper.selectAllMenu();

        /// then
        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .allMatch(menu -> menu != null) //allSatisfy문에서assertThat(menu).isNotNull()으로 써도 됨
                .allSatisfy(menu -> {
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf( /// satisfiesAnyOf최소한 하나를 만족하는지 검증
                            status -> "Y".equals(status),
                            status -> "N".equals(status)
                    );
                    /// NULL 이 가능한 컬럼은 검증 제외
                });
                /// isNotBlank() : 문자열이 존재해야 통과
                /// isNotNull : NULL이 아니어야 통과 -> 빈 문자열 가능
    }


    @DisplayName("메뉴코드 메뉴 한건 조회")
    @Test
    void selectMenuByMenuCode1() {
        int menuCode = 1;

        MenuDto result = menuMapper.selectMenuByMenuCode(menuCode);

        assertThat(result).isNotNull();
        assertThat(result.getMenuCode()).isEqualTo(menuCode);
        assertThat(result.getMenuName()).isNotNull();
        assertThat(result.getMenuPrice()).isNotZero().isPositive();
        assertThat(result.getOrderableStatus()).satisfiesAnyOf(
                status -> "Y".equals(status),
                status -> "N".equals(status)
        );
    }

    @DisplayName("존재하지 않는 메뉴 코드로 조회시 조회되서는 안됨")
    @Test
    void selectMenuByMenuCode2() {
        int menuCode = 123213232;

        MenuDto result = menuMapper.selectMenuByMenuCode(menuCode);

        assertThat(result).isNull();
    }


    @DisplayName("존재하는 카테고리 번호로 메뉴 목록 조회")
    @Test
    void selectMenuByCategoryCode1() {
        int categoryCode = 1;

        List<MenuDto> result = menuMapper.selectMenuByCategoryCode(categoryCode);

        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .allSatisfy(menu -> {
                    assertThat(menu).isNotNull();

                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                            status -> "Y".equals(status),
                            status -> "N".equals(status)
                    );
                });
    }

    @DisplayName("존재하지 않는 카테고리 번호로 메뉴 목록 조회시 빈 리스트 반환")
    @Test
    void selectMenuByCategoryCode2() {
        int categoryCode = 234;

        List<MenuDto> result = menuMapper.selectMenuByCategoryCode(categoryCode);

        result.isEmpty();
    }


    @Test
    void selectAllSubCategory() {

        List<CategoryDto> result = menuMapper.selectAllSubCategory();

        assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .allSatisfy(category -> {
                    assertThat(category).isNotNull();

                    assertThat(category.getCategoryCode()).isNotZero().isPositive();
                    assertThat(category.getCategoryName()).isNotNull().isNotEmpty(); /// isNotEmpty는 null을 고려하지 않아서 둘다 쓰는게 좋다.
                    assertThat(category.getRefCategoryCode()).isNotZero().isPositive();
                });
    }


    @Test
    void insertMenu() {
        String menuName = "테수트";
        int menuPrice = 1;
        int categoryCode = 3;
        String orderableStatus = "Y";

        MenuDto menu = MenuDto.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .categoryCode(categoryCode)
                .orderableStatus(orderableStatus)
                .build();

        int result = menuMapper.insertMenu(menu);
        if(result > 0) {
            sqlSession.commit();
        }

        assertThat(result).isEqualTo(1);

        int menuCode = menu.getMenuCode();
        assertThat(menuCode).isNotZero().isPositive();

        MenuDto reSelectMenu = menuMapper.selectMenuByMenuCode(menuCode);
        assertThat(reSelectMenu.getMenuCode()).isEqualTo(menuCode);
        assertThat(reSelectMenu.getMenuName()).isEqualTo(menuName);
        assertThat(reSelectMenu.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(reSelectMenu.getCategoryCode()).isEqualTo(categoryCode);
        assertThat(reSelectMenu.getOrderableStatus()).isEqualTo(orderableStatus);
    }

    @Test
    void updateMenuByMenuCode() {
        int menuCode = 59;
        String menuName = "변경할게";
        int menuPrice = 12;
        int categoryCode = 3;
        String orderableStatus = "N";

        MenuDto menu = MenuDto.builder()
                .menuCode(menuCode)
                .menuName(menuName)
                .menuPrice(menuPrice)
                .categoryCode(categoryCode)
                .orderableStatus(orderableStatus)
                .build();

        int result = menuMapper.updateMenuByMenuCode(menu);
        if(result == 1) {
            sqlSession.commit();
        }

        assertThat(result).isEqualTo(1);

        assertThat(menu.getMenuCode()).isEqualTo(menuCode);
        assertThat(menu.getMenuName()).isEqualTo(menuName);
        assertThat(menu.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(menu.getCategoryCode()).isEqualTo(categoryCode);
        assertThat(menu.getOrderableStatus()).isEqualTo(orderableStatus);
    }

    @Test
    void deleteMenuByMenuCode() {
        int menuCode = 59;

        int result = menuMapper.deleteMenuByMenuCode(menuCode);
        if(result == 1) {
            sqlSession.commit();
        }

        assertThat(result).isEqualTo(1);

        /// 삭제된 값이 null인지 확인
        assertThat(menuMapper.selectMenuByMenuCode(menuCode)).isNull();
    }
}
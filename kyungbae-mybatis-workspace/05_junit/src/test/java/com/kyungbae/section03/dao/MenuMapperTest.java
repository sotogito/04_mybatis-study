package com.kyungbae.section03.dao;

import com.kyungbae.section03.dto.CategoryDto;
import com.kyungbae.section03.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.kyungbae.section03.common.Template.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuMapperTest {

    private SqlSession sqlSession;
    private MenuMapper menuMapper;

    @BeforeEach
    void setUp() {
        sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
    }

    @AfterEach
    void tearDown() {
        sqlSession.close();
    }

    /*
        테스트 케이스 작성
        => 요구사항 대로 작성
        => given-when-then 패턴 적용해서 작성
     */


    @DisplayName("메뉴 전체 조회 검증")
    @Test
    void selectAllMenu() {
        // given

        // when
        List<MenuDto> menuList = menuMapper.selectAllMenu();

        // then
        assertThat(menuList)
                .isNotNull()
                .isNotEmpty()
                .allMatch(a -> a != null)
                .allSatisfy(a -> {
                    assertThat(a.getMenuCode()).isNotZero().isPositive();
                    assertThat(a.getMenuName()).isNotNull();
                    assertThat(a.getMenuPrice()).isNotZero().isPositive();
                    // NotNull 제약조건이 없는 컬럼은 검증 제외 (category_code)
                    assertThat(a.getOrderableStatus()).satisfiesAnyOf(
                            status -> "Y".equals(status),
                            status -> "N".equals(status)
                    );
                });
    }

    @DisplayName("메뉴코드로 메뉴 한건 조회")
    @Test
    void selectMenuByMenuCode1() {
        // given
        int menuCode = 1;

        // when
        MenuDto menu = menuMapper.selectMenuByMenuCode(menuCode);

        // then
        assertThat(menu).isNotNull();
        assertThat(menu.getMenuCode()).isEqualTo(menuCode);
        assertThat(menu.getMenuName()).isNotNull();
        assertThat(menu.getMenuPrice()).isNotZero().isPositive();
        assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                "Y"::equals,
                "N"::equals
        );

    }

    @DisplayName("존재하지 않는 메뉴코드로 조회시 조회되서는 안됨")
    @Test
    void selectMenuByMenuCode2() {
        // given
        int menuCode = 1987;

        // when
        MenuDto menu = menuMapper.selectMenuByMenuCode(menuCode);

        // then
        assertThat(menu).isNull();

    }

    @DisplayName("존재하는 카테고리번호로 메뉴 목록 조회")
    @Test
    void selectMenuByCategoryCode1() {
        // given
        int categoryCode = 4;

        // when
        List<MenuDto> list = menuMapper.selectMenuByCategoryCode(categoryCode);

        // then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allSatisfy(a -> {
                    assertThat(a.getMenuCode()).isNotZero().isPositive();
                    assertThat(a.getCategoryCode()).isEqualTo(categoryCode);
                    assertThat(a.getMenuName()).isNotNull();
                    assertThat(a.getMenuPrice()).isNotZero().isPositive();
                    assertThat(a.getOrderableStatus()).satisfiesAnyOf(
                            status -> "Y".equals(status),
                            status -> "N".equals(status)
                    );
                });

    }

    @DisplayName("존재하지않는 카테고리번호로 메뉴 조회시 빈 리스트 반환")
    @Test
    void selectMenuByCategoryCode2() {
        int categoryCode = 1432;
        List<MenuDto> list = menuMapper.selectMenuByCategoryCode(categoryCode);
        assertThat(list).isEmpty();
    }

    @DisplayName("하위 카테고리 목록 조회")
    @Test
    void selectCategory() {

        List<CategoryDto> list = menuMapper.selectCategory();
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch(category -> category.getRefCategoryCode() != 0);
    }

    @DisplayName("메뉴 삽입")
    @Test
    void insertMenu() {
        // given
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String  orderableStatus = "Y";

        MenuDto menu = MenuDto.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .categoryCode(categoryCode)
                .orderableStatus(orderableStatus)
                .build();

        // when
        int result = menuMapper.insertMenu(menu);
        if (result > 0) {
            sqlSession.commit();
        }
        // then
        assertThat(result).isEqualTo(1);

        int menuCode = menu.getMenuCode();
        assertThat(menuCode).isNotZero().isPositive();

        // 등록된 행을 다시 조회해서 컬럼값 비교
        MenuDto reSelectMenu = menuMapper.selectMenuByMenuCode(menuCode);
        assertThat(reSelectMenu.getMenuCode()).isEqualTo(menuCode);
        assertThat(reSelectMenu.getMenuName()).isEqualTo(menuName);
        assertThat(reSelectMenu.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(reSelectMenu.getCategoryCode()).isEqualTo(categoryCode);
        assertThat(reSelectMenu.getOrderableStatus()).isEqualTo(orderableStatus);

    }

    @Test
    void updateMenu() {
        int menuCode = 43;
        String menuName = "족발라떼";
        int menuPrice = 9000;
        int categoryCode = 8;
        String  orderableStatus = "N";

        MenuDto menu = new MenuDto(menuCode, menuName, menuPrice, categoryCode,orderableStatus);

        int result = menuMapper.updateMenu(menu);
        if (result > 0) {
            sqlSession.commit();
        }

        assertThat(result).isEqualTo(1);

        MenuDto reSelectMenu = menuMapper.selectMenuByMenuCode(menuCode);
        assertThat(reSelectMenu.getMenuCode()).isEqualTo(menuCode);
        assertThat(reSelectMenu.getMenuName()).isEqualTo(menuName);
        assertThat(reSelectMenu.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(reSelectMenu.getCategoryCode()).isEqualTo(categoryCode);
        assertThat(reSelectMenu.getOrderableStatus()).isEqualTo(orderableStatus);

    }

    @Test
    void deleteMenu() {

        int menuCode = 43;

        int result = menuMapper.deleteMenu(menuCode);
        if (result > 0) {
            sqlSession.commit();
        }
        assertThat(result).isEqualTo(1);
        assertThat(menuMapper.selectMenuByMenuCode(menuCode)).isNull();

    }
}
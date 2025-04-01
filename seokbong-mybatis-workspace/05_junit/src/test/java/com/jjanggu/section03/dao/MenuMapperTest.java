package com.jjanggu.section03.dao;

import com.jjanggu.section03.dto.CategoryDto;
import com.jjanggu.section03.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.jjanggu.section03.common.Template.getSqlSession;
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

       1) given (준비) : 어떤 데이터를 가지고
       2) when  (실행) : 어떤 메소드 실행시
       3) then  (검증) : 어떤 결과가 나와야되는지
     */

    @DisplayName("메뉴 전체 조회")
    @Test
    void selectAllMenu() {
        // given

        // when
        List<MenuDto> list = menuMapper.selectAllMenu();

        // then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch(menu -> menu != null)
                .allSatisfy(menu -> {
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    // nullable 한 컬럼은 검증 제외(category_code)
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf( // satisfiesAnyOf : 최소한 하나를 만족하는지 검증하는 메소드
                            status -> "Y".equals(status),
                            status -> "N".equals(status)
                    );
                });

    }


    @DisplayName("메뉴코드로 메뉴 한 건 조회")
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
                status -> "Y".equals(status),
                status -> "N".equals(status)
        );
    }

    @DisplayName("존재하지 않는 메뉴코드로 조회시 조회돼서는 안됨")
    @Test
    void selectMenuByMenuCode2() {

        // given
        int menuCode = 12345678;

        // when
        MenuDto menu = menuMapper.selectMenuByMenuCode(menuCode);

        // then
        assertThat(menu).isNull();
    }

    @DisplayName("존재하는 카테고리 번호로 메뉴 목록 조회")
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
                .allMatch(menu -> menu != null)
                .allSatisfy(menu -> {
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    assertThat(menu.getCategoryCode()).isEqualTo(categoryCode);
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                            status -> "Y".equals(status),
                            status -> "N".equals(status)
                    );
                });

    }

    @DisplayName("존재하지 않는 카테고리번호로 메뉴 조회시 빈 리스트 반환됨")
    @Test
    void selectMenuByCategoryCode2() {
        int categoryCode = 45678;
        List<MenuDto> list = menuMapper.selectMenuByCategoryCode(categoryCode);

        assertThat(list)
                .isNotNull()
                .isEmpty();
    }

    @DisplayName("하위 카테고리 목록 조회")
    @Test
    void selectAllSubCategory() {
        List<CategoryDto> list = menuMapper.selectAllSubCategory();

        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch(category -> category.getRefCategoryCode() != 0);
    }

    @DisplayName("신규 메뉴 추가")
    @Test
    void insertMenu() {
        // given
        String menuName = "가리비막국수";
        int menuPrice = 13000;
        int categoryCode = 4;
        String orderableStatus = "Y";

        MenuDto menu = MenuDto.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .categoryCode(categoryCode)
                .orderableStatus(orderableStatus)
                .build();

        int result = menuMapper.insertMenu(menu); // insert 후에 menu의 menuCode 필드에는 현재 생성된 메뉴번화가 담겨 있는
        if(result > 0)
            sqlSession.commit();

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
        int menuCode = 46;
        String menuName = "족발라떼";
        int menuPrice = 31000;
        int categoryCode = 5;
        String orderableStatus = "N";

        MenuDto menu = new MenuDto(menuCode, menuName, menuPrice, categoryCode, orderableStatus);

        int result = menuMapper.updateMenu(menu);
        if(result > 0)
            sqlSession.commit();

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

        int menuCode = 46;

        int result = menuMapper.deleteMenu(menuCode);
        if(result > 0)
            sqlSession.commit();

        assertThat(result).isEqualTo(1);
        assertThat(menuMapper.selectMenuByMenuCode(menuCode)).isNull();
    }
}
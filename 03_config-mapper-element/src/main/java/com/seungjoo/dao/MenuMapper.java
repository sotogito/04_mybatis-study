package com.seungjoo.dao;

import com.seungjoo.dto.MenuDto;
import com.seungjoo.dto.OrderDto;

import java.util.List;

public interface MenuMapper {
    // <resultMap> 의 extends 속성 테스트용
    List<MenuDto> testResultMapExtends1();
    List<MenuDto> testResultMapExtends2();

    // <resultMap> 의 하위 <association> 테스트용
    List<MenuDto> testResultMapAssociation();

    // <resultMap> 의 하위 <collection> 테스트용
    OrderDto testResultMapCollection(int code);

    // <sql> 테스트용
    MenuDto testSql(int code);

    // <selectKey>, useGeneratedKeys, keyProperty 속성 테스트용
    int insertCategory(MenuDto menu);
    int insertMenu(MenuDto menu);

}

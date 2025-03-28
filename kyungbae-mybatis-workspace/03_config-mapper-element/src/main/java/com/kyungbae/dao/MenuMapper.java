package com.kyungbae.dao;

import com.kyungbae.dto.MenuDto;
import com.kyungbae.dto.OrderDto;

import java.util.List;

public interface MenuMapper {
    List<MenuDto> testResultMapExtends1();

    List<MenuDto> testResultMapExtends2();

    // <resultMap> 의 하위 <association> 테스트용
    List<MenuDto> testResultMapAssociation();

    // <resultMap> 의 <collection> 테스트용
    List<OrderDto> testResultMapCollection(int orderCode);

    // <sql> 테스트용
    MenuDto testSql(int code);

    // keyProperty 테스트
    int insertCategory(MenuDto menu);
    int insertMenu(MenuDto menu);

}

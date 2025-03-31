package com.sotogito.dao;

import com.sotogito.dto.MenuDto;
import com.sotogito.dto.OrderDto;

import java.util.List;

public interface MenuMapper {

    List<MenuDto> testResultMapExtend1();

    List<MenuDto> testResultMapExtend2();

    List<MenuDto> testResultMapAssociation();

    OrderDto testResultMapCollection(int orderCode);

    MenuDto testSql(int menuCode);

    int insertCategory(MenuDto menu);

    int insertMenu(MenuDto menu);

}

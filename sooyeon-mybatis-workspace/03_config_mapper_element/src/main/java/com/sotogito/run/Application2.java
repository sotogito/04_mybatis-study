package com.sotogito.run;

import com.sotogito.dto.MenuDto;
import com.sotogito.service.MenuService;

import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        List<MenuDto> result = new MenuService().testResultMapAssociation();
        result.forEach(System.out::println);
    }
}

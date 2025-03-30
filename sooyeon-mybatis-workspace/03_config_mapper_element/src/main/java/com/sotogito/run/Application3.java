package com.sotogito.run;

import com.sotogito.dto.OrderDto;
import com.sotogito.service.MenuService;

import java.util.List;

public class Application3 {
    public static void main(String[] args) {
        
        /// 주문번호로 주문정보 검색 - 주문번호, 주문일, 주문시간, 총가겨
        OrderDto order = null;
        try {
            order = new MenuService().testResultMapCollection(908098);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println(order);
    }
}

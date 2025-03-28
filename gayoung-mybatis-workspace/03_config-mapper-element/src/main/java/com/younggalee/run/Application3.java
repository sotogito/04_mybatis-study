package com.younggalee.run;

import com.younggalee.dto.OrderDto;
import com.younggalee.dto.OrderMenuDto;
import com.younggalee.service.MenuService;

import java.util.List;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {
        //dto만들면 config가서 typeAlias등록해놓기
        // 주문번호로 주문정보(주문번호, 주문일자) 검색
        Scanner sc = new Scanner(System.in);
        int code = sc.nextInt();
        OrderDto order = new MenuService().testResultMapCollection(code);
        System.out.println(order);

        List<OrderMenuDto> orderMenuList = order.getOrderMenuList();
        for (OrderMenuDto orderMenu : orderMenuList){
            System.out.println(orderMenu);
        }
    }
}

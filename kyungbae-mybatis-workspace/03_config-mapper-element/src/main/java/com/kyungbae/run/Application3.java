package com.kyungbae.run;

import com.kyungbae.dto.OrderDto;
import com.kyungbae.dto.OrderMenuDto;
import com.kyungbae.service.MenuService;

import java.util.List;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 주문번호로 주문정보(주문번호, 주문일, 주문시간, 총가격, 주문메뉴(메뉴번호, 주문수량)) 검색
        System.out.print("주문번호 검색: ");
        String orderCode = sc.nextLine();

        List<OrderDto> list = new MenuService().testREsultMapCollection(Integer.parseInt(orderCode));
        for (OrderDto orderDto : list) {
            System.out.println("주문번호: " + orderDto.getOrderCode() + ", 주문날짜: " + orderDto.getOrderDate() + " " + orderDto.getOrderTime() + ", 총금액" + orderDto.getTotalOrderPrice() + "원");
            for (OrderMenuDto orderMenuDto : orderDto.getOrderMenuList()) {
                System.out.println("\t메뉴번호: " + orderMenuDto.getMenuCode() + ", 주문수량: " + orderMenuDto.getOrderAmount() + "개");
            }
        }


    }
}

package com.jjanggu.run;

import com.jjanggu.dto.OrderDto;
import com.jjanggu.service.MenuService;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Application3 {
    public static void main(String[] args) {

        // 주문번호로 주문정보 검색(주문번호, 주문일, 주문시간, 총가격, 주문메뉴들(메뉴번호, 주문수량)들) 검색
        Scanner sc = new Scanner(System. in);
        System.out.println("주문번호: ");
        int code = sc.nextInt();

        OrderDto order = new MenuService().testResultMapCollection(code);
        System.out.println(order);
    }
}

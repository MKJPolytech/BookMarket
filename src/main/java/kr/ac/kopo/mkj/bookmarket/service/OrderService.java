package kr.ac.kopo.mkj.bookmarket.service;

import kr.ac.kopo.mkj.bookmarket.domain.Order;

public interface OrderService {
    void confirmOrder(String bookId, long quantity); // 재고 수량
    Long saveOrder(Order order);
}

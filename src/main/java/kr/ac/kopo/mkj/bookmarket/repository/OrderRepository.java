package kr.ac.kopo.mkj.bookmarket.repository;

import kr.ac.kopo.mkj.bookmarket.domain.Order;

public interface OrderRepository {
    // 주문목록
    Long saveOrder(Order order);
}

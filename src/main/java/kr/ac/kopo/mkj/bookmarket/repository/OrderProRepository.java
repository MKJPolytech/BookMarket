package kr.ac.kopo.mkj.bookmarket.repository;

import kr.ac.kopo.mkj.bookmarket.domain.Order;

public interface OrderProRepository {
    void save(Order order);
}

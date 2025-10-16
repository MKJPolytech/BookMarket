// src/main/java/.../repository/OrderProRepositoryImpl.java
package kr.ac.kopo.mkj.bookmarket.repository;

import kr.ac.kopo.mkj.bookmarket.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderProRepositoryImpl implements OrderProRepository {
    private final Map<Long, Order> processed = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public void save(Order order) {
        Long id = order.getOrderId();
        if (id == null) {
            id = seq.getAndIncrement();
            order.setOrderId(id);
        }
        processed.put(id, order);
    }
}
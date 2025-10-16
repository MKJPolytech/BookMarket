package kr.ac.kopo.mkj.bookmarket.repository;

import kr.ac.kopo.mkj.bookmarket.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private Map<Long,Order> listOfOrders;
    private long nextOrderId;

    public OrderRepositoryImpl() {
        listOfOrders = new HashMap<>();
        nextOrderId = 2000;
    }

    @Override
    public Long saveOrder(Order order) {
        long id = getNextOrderId();
        order.setOrderId(id);
        listOfOrders.put(order.getOrderId(), order);
        return id;
    }

    private synchronized long getNextOrderId() {
        return nextOrderId++;
    }
}

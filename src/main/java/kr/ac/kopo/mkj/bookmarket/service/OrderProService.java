// src/main/java/.../service/OrderProService.java
package kr.ac.kopo.mkj.bookmarket.service;

import kr.ac.kopo.mkj.bookmarket.domain.Order;
import kr.ac.kopo.mkj.bookmarket.repository.OrderProRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProService {
    private final OrderProRepository orderProRepository;

    public void save(Order order){
        orderProRepository.save(order); // ✅ 올바른 위임
    }
}

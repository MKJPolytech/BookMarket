package kr.ac.kopo.mkj.bookmarket.repository;

import kr.ac.kopo.mkj.bookmarket.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository {
    private Map<String, Cart> listofCarts;

    public CartRepositoryImpl() {
        listofCarts = new HashMap<String, Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        if (listofCarts.containsKey(cart.getCartId())){
            throw new IllegalArgumentException("장바구니를 새로 생성할 수 없습니다. 현재 장바구니 ID(" +cart.getCartId() + ")가 이미 존재합니다.");
        }
        listofCarts.put(cart.getCartId(), cart);
        return cart;
    }

    public void update(String cartId, Cart cart) {
        if (listofCarts.containsKey(cartId)) {
            throw new IllegalArgumentException("장바구니 목록을 업데이트할 수 없습니다. 장바구니가 존재하지 않습니다.");
        }
        listofCarts.put(cartId, cart);
    }

    @Override
    public void delete(String cartId) {
        if(!listOfCarts.containsKey(cartId)){
            throw new IllegalArgumentException("장바구니 목록을 업데이트할 수 없습니다. 장바구니가 존재하지 않습니다.");
        }
        listOfCarts.remove(cartId);
    }

    @Override
    public Cart read(String cartId) {
        return listofCarts.get(cartId);
    }

}

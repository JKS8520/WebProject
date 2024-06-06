package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Cart;
import hgcq.appleshop.domain.CartItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CartItemRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(CartItem cartItem) {
        em.persist(cartItem);
    }

    public void delete(CartItem cartItem) {
        em.remove(cartItem);
    }

    public CartItem findById(Long id) {
        return em.find(CartItem.class, id);
    }

    public List<CartItem> findByCart(Cart cart) {
        return em.createQuery("select ci from CartItem ci where ci.cart = :cart", CartItem.class)
                .setParameter("cart", cart)
                .getResultList();
    }
}

package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Cart;
import hgcq.appleshop.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Cart cart) {
        em.persist(cart);
    }

    public Cart findById(Long id) {
        return em.find(Cart.class, id);
    }

    public Cart findByMember(Member member) {
        return em.createQuery("select c from Cart c where c.member = :member", Cart.class)
                .setParameter("member", member)
                .getSingleResult();
    }
}

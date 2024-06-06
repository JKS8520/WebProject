package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Item;
import hgcq.appleshop.domain.Member;
import hgcq.appleshop.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> findByMember(Member member) {
        return em.createQuery("select o from Order o where o.member = :member order by o.orderDate desc", Order.class)
                .setParameter("member", member)
                .getResultList();
    }

    public List<Order> findAll() {
        return em.createQuery("select o from Order o order by o.orderDate desc", Order.class)
                .getResultList();
    }
}

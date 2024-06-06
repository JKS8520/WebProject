package hgcq.appleshop.repository;

import hgcq.appleshop.domain.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderItemRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(OrderItem orderItem) {
        em.persist(orderItem);
    }

    public OrderItem findById(Long id) {
        return em.find(OrderItem.class, id);
    }
}

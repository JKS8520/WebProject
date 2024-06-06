package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Delivery;
import hgcq.appleshop.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DeliveryRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Delivery delivery) {
        em.persist(delivery);
    }

    public Delivery findById(Long id) {
        return em.find(Delivery.class, id);
    }

    public List<Delivery> findAll() {
        return em.createQuery("select d from Delivery d order by d.order.orderDate desc", Delivery.class)
                .getResultList();
    }

    public Delivery findByOrder(Order order) {
        return em.createQuery("select d from Delivery d where d.order = :order", Delivery.class)
                .setParameter("order", order)
                .getSingleResult();
    }
}

package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    @PersistenceContext
    private final EntityManager em;

    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findByView() {
        return em.createQuery("select i from Item i order by i.views", Item.class)
                .setMaxResults(8)
                .getResultList();
    }

    public List<Item> findBySell() {
        return em.createQuery("select i from Item i order by i.orders", Item.class)
                .setMaxResults(8)
                .getResultList();
    }

    public List<Item> findByName(String name) {
        return em.createQuery("select i from Item i where i.name = :name", Item.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Item> findByCategoryOrderName(String category) {
        return em.createQuery("select i from Item i where i.category = :category order by i.name desc", Item.class)
                .setParameter("category", category)
                .getResultList();
    }

    public List<Item> findByCategoryOrderPrice(String category) {
        return em.createQuery("select i from Item i where i.category = :category order by i.price", Item.class)
                .setParameter("category", category)
                .getResultList();
    }

    public List<Item> findByCategoryOrderPriceDesc(String category) {
        return em.createQuery("select i from Item i where i.category = :category order by i.price desc", Item.class)
                .setParameter("category", category)
                .getResultList();
    }
}

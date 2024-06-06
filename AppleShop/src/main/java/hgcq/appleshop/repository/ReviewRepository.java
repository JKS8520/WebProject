package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Item;
import hgcq.appleshop.domain.Member;
import hgcq.appleshop.domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Review review) {
        em.persist(review);
    }

    public void delete(Review review) {
        em.remove(review);
    }

    public Review findById(Long id) {
        return em.find(Review.class, id);
    }

    public List<Review> findByItem(Item item) {
        return em.createQuery("select r from Review r where r.item = :item order by r.created desc", Review.class)
                .setParameter("item", item)
                .getResultList();
    }

    public List<Review> findByMember(Member member) {
        return em.createQuery("select r from Review r where r.member = :member order by r.created desc", Review.class)
                .setParameter("member", member)
                .getResultList();
    }
}

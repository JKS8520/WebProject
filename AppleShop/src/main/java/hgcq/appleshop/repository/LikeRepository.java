package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Item;
import hgcq.appleshop.domain.Like;
import hgcq.appleshop.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LikeRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Like like) {
        em.persist(like);
    }

    public void delete(Like like) {
        em.remove(like);
    }

    public Like findById(Long id) {
        return em.find(Like.class, id);
    }

    public List<Item> findAll(Member member) {
        return em.createQuery("select l.item from Like l where l.member = :member", Item.class)
                .setParameter("member", member)
                .getResultList();
    }
}

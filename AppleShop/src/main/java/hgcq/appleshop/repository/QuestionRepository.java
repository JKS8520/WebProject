package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Item;
import hgcq.appleshop.domain.Member;
import hgcq.appleshop.domain.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Question question) {
        em.persist(question);
    }

    public void delete(Question question) {
        em.remove(question);
    }

    public Question findById(Long id) {
        return em.find(Question.class, id);
    }

    public List<Question> findByItem(Item item) {
        return em.createQuery("select q from Question q where q.item = :item", Question.class)
                .setParameter("item", item)
                .getResultList();
    }

    public List<Question> findByMember(Member member) {
        return em.createQuery("select q from Question q where q.member = :member", Question.class)
                .setParameter("member", member)
                .getResultList();
    }
}

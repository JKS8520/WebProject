package hgcq.appleshop.repository;

import hgcq.appleshop.domain.Answer;
import hgcq.appleshop.domain.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnswerRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Answer answer) {
        em.persist(answer);
    }

    public void delete(Answer answer) {
        em.remove(answer);
    }

    public Answer findById(Long id) {
        return em.find(Answer.class, id);
    }

    public List<Answer> findByQuestion(Question question) {
        return em.createQuery("select a from Answer a where a.question = :question order by a.created desc", Answer.class)
                .setParameter("question", question)
                .getResultList();
    }
}

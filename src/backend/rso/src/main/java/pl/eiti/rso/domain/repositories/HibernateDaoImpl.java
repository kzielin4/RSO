package pl.eiti.rso.domain.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class HibernateDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public HibernateDaoImpl() {
    }

    public void save(Object obj) {
        entityManager.persist(obj);
    }

    public void saveAndFlash(Object obj) {
        entityManager.persist(obj);
        entityManager.flush();
    }

    public void remove(Object obj) {
        entityManager.remove(obj);
    }

    public void removeAndFlash(Object obj) {
        entityManager.remove(obj);
        entityManager.flush();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void flush() {
        entityManager.flush();
    }

}

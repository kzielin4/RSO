package pl.eiti.rso.domain.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.eiti.rso.domain.entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    Logger log = LoggerFactory.getLogger(HibernateDaoImpl.class);

    public HibernateDaoImpl() {
    }

    public void save(BaseEntity obj) {
        entityManager.persist(obj);
        log.debug("Save obj: " + obj.getClass().toString());
    }

    public void saveList(List<BaseEntity> objects) {
        for (BaseEntity obj : objects) {
            save(obj);
        }
    }

    public void saveListAndFlush(List<? extends BaseEntity> objects) {
        for (BaseEntity obj : objects) {
            save(obj);
        }
        entityManager.flush();
    }

    public void removeListAndFlush(List<? extends BaseEntity> objects) {
        for (BaseEntity obj : objects) {
            remove(obj);
        }
        entityManager.flush();
    }

    public void saveAndFlash(BaseEntity obj) {
        entityManager.persist(obj);
        entityManager.flush();
        log.debug("Save obj: " + obj.getClass().toString() + obj.getId());
    }

    public void remove(BaseEntity obj) {
        if (entityManager.contains(obj)) {
            entityManager.remove(obj);
        }
        log.debug("Remove obj: " + obj.getClass().toString() + obj.getId());
    }

    public void removeAndFlash(BaseEntity obj) {
        entityManager.remove(obj);
        entityManager.flush();
        log.debug("Save obj: " + obj.getClass().toString() + obj.getId());
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void flush() {
        entityManager.flush();
    }

    public BaseEntity getEntity(Class classToLoad, Long id) {
        return (BaseEntity) entityManager.find(classToLoad, id);
    }

}

package product.rest.api.integration;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
public class CustomObjectDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
    @PersistenceContext(unitName = "manager", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager = emf.createEntityManager();

    @Transactional
    public Integer insert(CustomObjectEntity entity) {

        entityManager.getTransaction().begin();

        CustomObjectEntity merge = entityManager.merge(entity);

        //  entityManager.joinTransaction();
        entityManager.getTransaction().commit();

        return merge.getId();
    }

    public CustomObjectEntity getByID(int id) {
        entityManager.getTransaction().begin();

        CustomObjectEntity entity = entityManager.find(CustomObjectEntity.class, id);

        return entity;

    }

}

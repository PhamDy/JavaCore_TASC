package dypham.page.demo.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryRepositoryClass {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Object[]> getAllCategories() {
        // Create a StoredProcedureQuery
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GETALLCATEGORIES")
                .registerStoredProcedureParameter(1, Object.class, ParameterMode.REF_CURSOR);

        // Execute and get results
        return query.getResultList();
    }
}

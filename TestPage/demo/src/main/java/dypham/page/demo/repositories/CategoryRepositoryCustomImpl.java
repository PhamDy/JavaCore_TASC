package dypham.page.demo.repositories;

import dypham.page.demo.model.CategoryDto;
import dypham.page.demo.model.ProductDto1;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CategoryDto> getListCategoriesWithPagination(String name, Double price, int pageSize, int pageOffset) {
        Query query = entityManager.createNativeQuery(
                        "CALL GetListCategory(:name, :price, :pageSize, :pageOffset)")
                .setParameter("name", name)
                .setParameter("price", price)
                .setParameter("pageSize", pageSize)
                .setParameter("pageOffset", pageOffset);

        List<Object[]> results = query.getResultList();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        results.forEach(result -> {
            Long categoryId = ((Number) result[0]).longValue();
            String categoryName = (String) result[1];
            Long productId = ((Number) result[2]).longValue();
            String productName = (String) result[3];
            Double productPrice = ((Number) result[4]).doubleValue();

            ProductDto1 productDto = new ProductDto1(productId, productName, productPrice);

            CategoryDto categoryDto = categoryDtos.stream()
                    .filter(c -> c.getCategory_id().equals(categoryId))
                    .findFirst()
                    .orElseGet(() -> {
                        CategoryDto newCategoryDto = new CategoryDto(categoryId, categoryName, new ArrayList<>());
                        categoryDtos.add(newCategoryDto);
                        return newCategoryDto;
                    });

            categoryDto.getList().add(productDto);
        });

        return categoryDtos;
    }
}

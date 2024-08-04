package dypham.page.demo.service;

import dypham.page.demo.entity.Category;
import dypham.page.demo.model.CategoryDto;
import dypham.page.demo.model.ProductDto1;
import dypham.page.demo.repositories.CategoryRepository;
import dypham.page.demo.repositories.CategoryRepositoryClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryRepositoryClass categoryRepositoryClass;

//    public List<CategoryDto> getCategory(){
//        return categoryRepository.getListCategory1(null, null, 3, 0);
//    }


    public List<CategoryDto> getFilteredCategories(
            String name,
            Double price,
            int pageSize,
            int pageOffset
    ) {

        List<Object[]> result = categoryRepository.getListCategory(name, price, pageSize, pageOffset);

        // Xử lý kết quả trả về
        Map<Long, CategoryDto> categoryMap = new HashMap<>();
        for (Object[] row : result) {
            Long categoryId = (Long) row[0];
            String categoryName = (String) row[1];
            String products = (String) row[2];

            CategoryDto categoryDto = categoryMap.computeIfAbsent(categoryId, id -> new CategoryDto(categoryId, categoryName, new ArrayList<>()));

            // Chuyển đổi chuỗi products thành danh sách các đối tượng ProductDto1
            if (products != null && !products.isEmpty()) {
                String[] productItems = products.split(",");
                for (String item : productItems) {
                    String[] productDetails = item.split(":");
                    Long productId = Long.parseLong(productDetails[0]);
                    String productName = productDetails[1];
                    Double productPrice = Double.parseDouble(productDetails[2]);
                    categoryDto.getList().add(new ProductDto1(productId, productName, productPrice));
                }
            }
        }

        return new ArrayList<>(categoryMap.values());
    }

    public List<Category> getAllCategories() {
        List<Object[]> result = categoryRepositoryClass.getAllCategories();
        List<Category> categories = new ArrayList<>();

        for (Object[] row : result) {
            Long categoryId = ((Number) row[0]).longValue();
            String name = (String) row[1];

            categories.add(new Category(categoryId, name));
        }

        return categories;
    }

}

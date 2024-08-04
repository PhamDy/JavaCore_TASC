package dypham.page.demo.repositories;

import dypham.page.demo.model.CategoryDto;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<CategoryDto> getListCategoriesWithPagination(String name, Double price, int pageSize, int pageOffset);
}

package dypham.page.demo.repositories;

import dypham.page.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    @Procedure(name = "Category.getListCategory")
//    List<CategoryDto> getListCategory(@Param("NAME") String name, @Param("price") Double price);

    @Query(value = "CALL GetListCategory(:NAME, :price, :pageSize, :pageOffset)", nativeQuery = true)
    List<Object[]> getListCategory(
            @Param("NAME") String name,
            @Param("price") Double price,
            @Param("pageSize") Integer pageSize,
            @Param("pageOffset") Integer pageOffset
    );

    @Query(value = "SELECT * FROM CATEGORY", nativeQuery = true)
    List<Category> findAllBy();

    @Procedure(procedureName = "GetAllCategories")
    List<Category> getAllCategories();

}

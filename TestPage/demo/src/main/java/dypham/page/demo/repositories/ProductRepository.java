package dypham.page.demo.repositories;

import dypham.page.demo.entity.Product;
import dypham.page.demo.model.ProductDto;
import dypham.page.demo.model.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query(value = "SELECT new dypham.page.demo.model.ProductDto(p.product_id, p.product_name, p.avatar, p.description, p.price, p.discount, p.quantity) FROM Product p WHERE p.product_name LIKE %:name%")
//    Page<ProductDto> getProductsByName(String name, Pageable pageable);

    @Query(value = "SELECT p.product_id, p.product_name, p.avatar, p.description, p.price, p.status, p.discount, p.quantity, c.name AS categoryName " +
            "FROM products p JOIN category c ON c.category_id = p.category_id WHERE p.product_id = :id",
            nativeQuery = true)
    ProductProjection getByIdTest(@Param("id") Long id);


    @Procedure(name = "Product.getProductById")
    ProductDto getProductById(@Param("productId") Long productId);

    @Procedure(name = "Product.getProductByName")
    List<ProductDto> getProductByName(@Param("productName") String productName);

}



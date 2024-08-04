package dypham.page.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import dypham.page.demo.model.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "products")
@SqlResultSetMapping(
        name = "ProductDtoMapping",
        classes = @ConstructorResult(
                targetClass = ProductDto.class,
                columns = {
                        @ColumnResult(name = "product_id", type = Long.class),
                        @ColumnResult(name = "product_name", type = String.class),
                        @ColumnResult(name = "avatar", type = String.class),
                        @ColumnResult(name = "description", type = String.class),
                        @ColumnResult(name = "price", type = Double.class),
                        @ColumnResult(name = "discount", type = Float.class),
                        @ColumnResult(name = "quantity", type = Long.class),
                        @ColumnResult(name = "name", type = String.class)
                }
        )
)
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Product.getProductById",
                procedureName = "GetProductById",
                resultSetMappings = "ProductDtoMapping",
                parameters = {
                        @StoredProcedureParameter(name = "productId", mode = ParameterMode.IN, type = Long.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "Product.getProductByName",
                procedureName = "GetProductByName",
                resultSetMappings = "ProductDtoMapping",
                parameters = {
                        @StoredProcedureParameter(name = "productName", mode = ParameterMode.IN, type = String.class)
                }
        )
})
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long product_id;

    private String product_name;
    private String avatar;
    private String img1;
    private String img2;
    private String img3;
    private String description;
    private double price;

    @Column(name = "status", nullable = true)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    private float discount;
    private long quantity;

    @Column(name = "category_id")
    private Long category_id;
}

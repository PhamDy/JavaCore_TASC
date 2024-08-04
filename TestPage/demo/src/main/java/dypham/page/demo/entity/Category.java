package dypham.page.demo.entity;

import dypham.page.demo.model.CategoryDto;
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
@Table(name = "category")
@SqlResultSetMapping(
        name = "CategoryDtoMapping",
        classes = {
                @ConstructorResult(
                        targetClass = CategoryDto.class,
                        columns = {
                                @ColumnResult(name = "category_id", type = Long.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "product_id", type = Long.class),
                                @ColumnResult(name = "product_name", type = String.class),
                                @ColumnResult(name = "price", type = Double.class)
                        }
                )
        }
)
@NamedStoredProcedureQuery(
        name = "Category.getListCategory",
        procedureName = "GetListCategory",
        resultSetMappings = "CategoryDtoMapping",
        parameters = {
                @StoredProcedureParameter(name = "NAME", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "price", mode = ParameterMode.IN, type = Double.class)
        }
)
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long category_id;

    @Column
    private String name;
}

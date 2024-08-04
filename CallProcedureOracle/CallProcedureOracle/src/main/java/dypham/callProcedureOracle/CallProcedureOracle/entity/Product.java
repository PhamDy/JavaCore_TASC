package dypham.callProcedureOracle.CallProcedureOracle.entity;


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

    @Lob
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

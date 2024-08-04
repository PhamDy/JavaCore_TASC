package dypham.page.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductDto {
    private Long product_id;
    private String product_name;
    private String avatar;
    private String description;
    private double price;
    private float discount;
    private long quantity;
    private String categoryName;
}

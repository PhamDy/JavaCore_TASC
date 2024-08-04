package dypham.callProcedureOracle.CallProcedureOracle.models;

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
    private Double price;
    private String category_name;
}

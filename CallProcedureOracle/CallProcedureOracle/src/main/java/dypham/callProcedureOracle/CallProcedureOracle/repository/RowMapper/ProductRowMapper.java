package dypham.callProcedureOracle.CallProcedureOracle.repository.RowMapper;

import dypham.callProcedureOracle.CallProcedureOracle.models.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductDto> {

    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ProductDto
                .builder()
                .product_id(rs.getLong("PRODUCT_ID"))
                .product_name(rs.getString("PRODUCT_NAME"))
                .price(rs.getDouble("PRICE"))
                .category_name(rs.getString("NAME"))
                .build();
    }
}

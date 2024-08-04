package dypham.callProcedureOracle.CallProcedureOracle.repository;

import dypham.callProcedureOracle.CallProcedureOracle.entity.Product;
import dypham.callProcedureOracle.CallProcedureOracle.models.ProductDto;
import dypham.callProcedureOracle.CallProcedureOracle.repository.RowMapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductJDBC {

    private final String schema = "SYSTEM";
    private final String procedure = "GetListProduct";
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcCall simpleJdbcCall;

    public ProductJDBC(@Qualifier("ConnectOacleJDBC") DataSource dataSource) {
         this.jdbcTemplate = new JdbcTemplate(dataSource);
         this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(schema.toUpperCase());

    }

    public Map<String, Object> getListProduct(Double price, String name, Integer page, Integer size){
        int offset = (page - 1) * size;

        simpleJdbcCall
                .withProcedureName(procedure.toUpperCase())
                .declareParameters(new SqlParameter[]{
                        new SqlParameter("p_price", Types.DOUBLE),
                        new SqlParameter("c_name", Types.VARBINARY),
                        new SqlParameter("p_size", Types.INTEGER),
                        new SqlParameter("p_offset", Types.INTEGER),
                        new SqlParameter("p_price", Types.DOUBLE),
                        new SqlOutParameter("result", Types.REF_CURSOR),
                        new SqlOutParameter("total_elements", Types.NUMERIC)
                })
                .returningResultSet("result", new ProductRowMapper());

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("p_price", price);
        mapSqlParameterSource.addValue("p_name", name);
        mapSqlParameterSource.addValue("p_size", size);
        mapSqlParameterSource.addValue("p_offset", offset);
        Map<String, Object> result  = simpleJdbcCall.execute(mapSqlParameterSource);

        @SuppressWarnings("unchecked")
        List<ProductDto> productDtoList = (List<ProductDto>) result.get("result");
        int totalElements = ((Number) result.get("total_elements")).intValue();
        int totalPages = (int) Math.ceil((double) totalElements / size);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("page", page);
        responseData.put("size", size);
        responseData.put("totalElements", totalElements);
        responseData.put("totalPages", totalPages);
        responseData.put("listData", productDtoList);

        return responseData;




    }

    public List<Product> getAll(){
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
    }

}

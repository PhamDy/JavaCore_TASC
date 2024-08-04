package dypham.callProcedureOracle.CallProcedureOracle.repository;

import dypham.callProcedureOracle.CallProcedureOracle.entity.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryJDBC {

    private final SimpleJdbcCall simpleJdbcCall;

    public CategoryJDBC(@Qualifier("ConnectOacleJDBC") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
    }

    public List<Category> categoryList(){
        simpleJdbcCall
                .withSchemaName("SYSTEM")
                .withProcedureName("GETALLCATEGORIES")
                .declareParameters(new SqlParameter[]{
                        new SqlParameter("cat_cursor", Types.REF_CURSOR),

                })
                .returningResultSet("cat_cursor", new RowMapper<Category>() {
                    @Override
                    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Category category = new Category();
                        category.setCategory_id(rs.getLong("CATEGORY_ID"));
                        category.setName(rs.getString("NAME"));
                        category.setUpdated_at((rs.getTimestamp("UPDATED_AT"))!=null ? (rs.getTimestamp("UPDATED_AT")).toLocalDateTime() : null);
                        category.setUpdated_at((rs.getTimestamp("CREATED_AT"))!=null ? (rs.getTimestamp("CREATED_AT")).toLocalDateTime() : null);
                        category.setCreated_by(rs.getString("CREATED_BY"));
                        category.setUpdated_by(rs.getString("UPDATED_BY"));
                        return category;
                    }
                });

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        Map<String, Object> results = simpleJdbcCall.execute();
        List<Category> categoryList = (List<Category>) results.get("cat_cursor");
        return categoryList;
    }


}

package dypham.callProcedureOracle.CallProcedureOracle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConnect {

    @Bean(name = "ConnectOacleJDBC")
    public DataSource myDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCLCDB");
        dataSource.setUsername("system");
        dataSource.setPassword("YourPassword123");
        return dataSource;
    }

}

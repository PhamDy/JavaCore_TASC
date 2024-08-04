package dypham.callProcedureOracle.CallProcedureOracle.service;

import dypham.callProcedureOracle.CallProcedureOracle.entity.Product;
import dypham.callProcedureOracle.CallProcedureOracle.models.ProductDto;
import dypham.callProcedureOracle.CallProcedureOracle.repository.ProductJDBC;
import dypham.callProcedureOracle.CallProcedureOracle.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductJDBC productJDBC;

    public List<Product> getProduct(){
        return productJDBC.getAll();
    }

    public Map<String, Object> getProductDto(Double price, String name, Integer page, Integer size){
        return productJDBC.getListProduct(price, name, page, size);
    }

}

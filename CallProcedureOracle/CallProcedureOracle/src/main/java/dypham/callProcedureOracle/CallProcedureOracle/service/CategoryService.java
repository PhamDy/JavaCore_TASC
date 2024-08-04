package dypham.callProcedureOracle.CallProcedureOracle.service;

import dypham.callProcedureOracle.CallProcedureOracle.entity.Category;
import dypham.callProcedureOracle.CallProcedureOracle.repository.CategoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryJDBC categoryJDBC;

    public List<Category> getCategory(){
        return categoryJDBC.categoryList();
    }

}

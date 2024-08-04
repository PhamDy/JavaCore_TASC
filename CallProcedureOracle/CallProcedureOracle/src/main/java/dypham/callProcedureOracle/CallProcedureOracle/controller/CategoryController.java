package dypham.callProcedureOracle.CallProcedureOracle.controller;

import dypham.callProcedureOracle.CallProcedureOracle.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

//    @GetMapping
    public ResponseEntity<?> getCategory(){
        return new ResponseEntity<>(categoryService.getCategory(), HttpStatus.OK);
    }

}

package dypham.page.demo.controller;

import dypham.page.demo.repositories.CategoryRepository;
import dypham.page.demo.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

//    @GetMapping
//    public ResponseEntity<?> getCategoryList(){
//        return new ResponseEntity<>(categoryService.getFilteredCategories(null, null, 10, 0), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<?> getCategoryListOracle(){
//        log.info(categoryRepository.findAllBy().toString());
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

}

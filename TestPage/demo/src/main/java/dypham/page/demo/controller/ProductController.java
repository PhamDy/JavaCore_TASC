package dypham.page.demo.controller;

import dypham.page.demo.model.ApiResponse;
import dypham.page.demo.repositories.ProductRepository;
import dypham.page.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

//    @GetMapping
//    public ResponseEntity<ApiResponse> getProducts(@RequestParam Optional<String> name,
//                                                   @RequestParam Optional<Integer> page,
//                                                   @RequestParam Optional<Integer> size){
//        return ResponseEntity.ok().body(
//                ApiResponse
//                        .builder()
//                        .timeStamp(LocalDateTime.now().toString())
//                        .data(Map.of("page", productService.getProducts(name.orElse(""), page.orElse(0), size.orElse(10))))
//                        .message("OK")
//                        .status(HttpStatus.OK)
//                        .statusCode(HttpStatus.OK.value())
//                        .build()
//        );
//    }

    @GetMapping
    public ResponseEntity<?> getProductByIdTest(){
        return new ResponseEntity<>(productRepository.getByIdTest(1L), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<?> getProductByName(){
        return new ResponseEntity<>(productService.getProductByName(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<?> getProductById(){
        return new ResponseEntity<>(productService.getProductById(), HttpStatus.OK);
    }

}

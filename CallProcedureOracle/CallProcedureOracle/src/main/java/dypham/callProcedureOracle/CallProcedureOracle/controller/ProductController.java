package dypham.callProcedureOracle.CallProcedureOracle.controller;

import dypham.callProcedureOracle.CallProcedureOracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProducts(){
        return new ResponseEntity<>(productService.getProduct(), HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<?> getProductsDto(@RequestParam(required = false) Double price,
                                            @RequestParam(required = false) String name,
                                            @RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "10") int size) {

        Map<String, Object> data = productService.getProductDto(price, name, page, size);

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("statusCode", HttpStatus.OK.value());
        responseBody.put("message", "success");
        responseBody.put("data", data);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

}

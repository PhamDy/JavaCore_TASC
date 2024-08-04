package dypham.page.demo.service;

import dypham.page.demo.entity.Product;
import dypham.page.demo.model.ProductDto;
import dypham.page.demo.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public Product findById(){
        Product product = productRepository.findById(1L).get();
        log.info(product.toString());
        return product;
    }

//    public Page<ProductDto> getProducts(String name, int page, int size){
//        log.info("Fetching products from page {} of size {}", page, size);
//        return productRepository.getProductsByName(name, PageRequest.of(page, size));
//    }


    public List<ProductDto> getProductByName() {
        List<ProductDto> product = productRepository.getProductByName("Benson Chair");
        log.info(product.toString());
        return product;
    }

    public ProductDto getProductById() {
        ProductDto product = productRepository.getProductById(1L);
        log.info(product.toString());
        return product;
    }


}

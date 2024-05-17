package com.DyPham.ProductService.service;

import com.DyPham.ProductService.entity.Product;
import com.DyPham.ProductService.exception.ProductQuantityCustomException;
import com.DyPham.ProductService.exception.ProductServiceCustomException;
import com.DyPham.ProductService.model.ProductRequest;
import com.DyPham.ProductService.model.ProductResponse;
import com.DyPham.ProductService.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");
        Product product = Product
                .builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);
        log.info("Product Created");
        return product.getId();
    }

    @Override
    public ProductResponse getProductById(long id) {
        log.info("Get the product for productId: {}", id);
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProductServiceCustomException("Product with given id not found")
        );
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product,
                productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id: {}", quantity, productId);
        var product = productRepository.findById(productId).orElseThrow(
                () -> new ProductServiceCustomException("Product with given id not found")
        );

        if (product.getQuantity() < quantity){
            throw new ProductQuantityCustomException("Product does not have sufficient Quantity");
        }

        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Product Quantity updated ");

    }
}

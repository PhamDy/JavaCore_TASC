package com.DyPham.ProductService.service;

import com.DyPham.ProductService.model.ProductRequest;
import com.DyPham.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);

    void reduceQuantity(long productId, long quantity);

}

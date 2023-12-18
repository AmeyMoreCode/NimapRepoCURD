package com.nimap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.dtos.ProductSave;
import com.nimap.model.Category;
import com.nimap.model.Product;
import com.nimap.repository.CategoryRepository;
import com.nimap.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

//    public Product createProduct(Product product) {
//    	System.out.println("ADDPSER = "+product);
//        return productRepository.save(product);
//    }
    
    public Product createProduct(ProductSave product) {
        java.util.Optional<Category> categoryOptional = categoryRepository.findById(product.getCategoryId());
        if (categoryOptional.isPresent()) {
        	Product productEntity = new Product();
        	productEntity.setPrice(product.getPrice());
        	productEntity.setName(product.getName());
        	productEntity.setCategory(categoryOptional.get());
            return productRepository.save(productEntity);
        }
        return null;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id); // Ensure the ID matches
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    
}

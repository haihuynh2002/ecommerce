package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.util.ImageUtil;

/**
 *
 * @author infoh
 */
@Service
@Transactional
public class ProductService {

    // private static String uploadDirectory =
    // "src/main/resources/static/image/product/";

    @Autowired
    ProductRepository pr;

    @Autowired
    UserRepository ur;

    @Autowired
    UserService us;

    public Product findById(Long id) {
        return pr.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Product not found"));
    }

    public List<Product> findAll() {
        return pr.findAll();
    }

    public Product create(Product product, MultipartFile image) {
        if(image != null) {
            String imageUrl = ImageUtil.saveImage(image, "src/main/resources/static/images/book/", "/images/book/");
            product.setImgUrl(imageUrl);
        }
        return pr.save(product);
    }

    public Product update(Product product) {
        return pr.save(product);
    }

    public void delete(Long id) {
        pr.deleteById(id);
    }
}

package org.eduardomango.practicaspringweb.model.services;

import org.eduardomango.practicaspringweb.model.entities.ProductEntity;
import org.eduardomango.practicaspringweb.model.exceptions.ProductNotFoundException;
import org.eduardomango.practicaspringweb.model.exceptions.UserNotFoundException;
import org.eduardomango.practicaspringweb.model.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
    public ProductEntity findById(long id) {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(ProductNotFoundException::new);
    }

    public ProductEntity findByName(String name){
        return productRepository.findAll()
                .stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    public List<ProductEntity> findMoreExpensiveThan(Double price){
        return productRepository.findAll()
                .stream()
                .filter(user -> user.getPrice() > price)
                .toList();
    }

    public void save(ProductEntity p) {
        productRepository.save(p);
    }

    public void delete(ProductEntity p) {
        productRepository.delete(p);
    }

    public void update(ProductEntity p) {
        productRepository.update(p);
    }
}

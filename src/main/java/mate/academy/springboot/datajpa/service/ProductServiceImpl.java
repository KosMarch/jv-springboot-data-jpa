package mate.academy.springboot.datajpa.service;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.springboot.datajpa.model.Category;
import mate.academy.springboot.datajpa.model.Product;
import mate.academy.springboot.datajpa.repository.ProductRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getReferenceById(id);
    }

    @Override
    public Product update(Product product) {
        Product reference = productRepository.getReferenceById(product.getId());
        reference.setPrice(product.getPrice());
        reference.setTitle(product.getTitle());
        reference.setCategory(product.getCategory());
        return productRepository.save(reference);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(getById(id));
    }

    @Override
    public List<Product> findAllByPriceBetween(BigDecimal from, BigDecimal to) {
        return productRepository.findAllByPriceBetween(from, to);
    }

    @Override
    public List<Product> findAllByCategory(List<Category> categories) {
        return productRepository.findAllByCategoryIn(categories);
    }
}

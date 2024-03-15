package ch.noseryoung.sbdemo01.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    public Optional<Product> getById(Integer id) {
        return repository.findById(id);
    }
    public List<Product> getAll() {
        PageRequest firstPageTenElements = PageRequest.of(1, 10);
        PageRequest secondPageTwentyElements = PageRequest.of(2, 20);
        return repository.findAll();
    }



}

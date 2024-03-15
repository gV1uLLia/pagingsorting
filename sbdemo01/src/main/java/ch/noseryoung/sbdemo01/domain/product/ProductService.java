package ch.noseryoung.sbdemo01.domain.product;

import ch.noseryoung.sbdemo01.domain.pagination.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Page<Product> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Product> getById(Integer id) {
        return repository.findById(id);
    }
    public Page<Product> getAll(Pageable pageable) {
        PageRequest firstPageTenElements = PageRequest.of(1, 10);
        PageRequest secondPageTwentyElements = PageRequest.of(2, 20);
        return repository.findAll(pageable);
    }

    public Page<Foo> findPaginated(int page, int size) {
        return null; //TODO: REPLACE WITH PAGE
    }
}

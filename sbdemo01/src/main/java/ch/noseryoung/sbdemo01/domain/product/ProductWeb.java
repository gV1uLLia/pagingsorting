package ch.noseryoung.sbdemo01.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductWeb {
    Pageable firstPageWithTwoElements = (Pageable) PageRequest.of(0, 2);

    Pageable secondPageWithFiveElements = (Pageable) PageRequest.of(1, 5);

    @Autowired
    private ProductService service;

    @GetMapping()
    public Page<Product> getProducts(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> findById
            (@PathVariable("productId") Integer productId) {
        return ResponseEntity.ok().body(service.getById(productId));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException nsee) {
        return ResponseEntity.status(404).body(nsee.getMessage());
    }

}

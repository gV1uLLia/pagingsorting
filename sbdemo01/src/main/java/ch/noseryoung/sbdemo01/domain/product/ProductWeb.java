package ch.noseryoung.sbdemo01.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductWeb {


    @Autowired
    private ProductService productService;

    @GetMapping()
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {

        Sort sortOrder = Sort.by(sort[0]);
        PageRequest pageable = PageRequest.of(page, size, sortOrder);
        return productService.listAll((Pageable) pageable);
    }



}

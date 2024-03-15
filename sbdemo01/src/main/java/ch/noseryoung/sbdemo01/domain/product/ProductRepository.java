package ch.noseryoung.sbdemo01.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Integer id);

}
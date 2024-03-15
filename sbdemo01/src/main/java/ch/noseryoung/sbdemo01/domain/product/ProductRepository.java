package ch.noseryoung.sbdemo01.domain.product;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findAllByPrice(double price, Pageable pageable);
    Pageable firstPageTenElements = (Pageable) PageRequest.of(1, 10);
    Pageable secondPageTwentyElements = (Pageable) PageRequest.of(2, 20);

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    /**
     * Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
     *
     * Pageable secondPageWithFiveElements = PageRequest.of(1, 5);
     */

}

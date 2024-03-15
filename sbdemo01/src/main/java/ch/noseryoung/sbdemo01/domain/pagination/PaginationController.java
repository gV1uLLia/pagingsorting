package ch.noseryoung.sbdemo01.domain.pagination;

import ch.noseryoung.sbdemo01.domain.product.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pagination")
public class PaginationController {

    ProductService service;
    private ApplicationEventPublisher eventPublisher;

    @GetMapping(params = { "page", "size" })
    public List<Foo> findPaginated(@RequestParam("page") int page,
                                   @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
                                   HttpServletResponse response) throws Exception {
        Page<Foo> resultPage = service.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new Exception();
        }
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Foo>(
                Foo.class, uriBuilder, response, page, resultPage.getTotalPages(), size));

        return resultPage.getContent();
    }
}

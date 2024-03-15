package ch.noseryoung.sbdemo01.domain.pagination;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pagination")
public class PaginationController {
    @GetMapping(params = { "page", "size" })
    public List<Foo> findPaginated(@RequestParam("page") int page,
                                   @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
                                   HttpServletResponse response) {
        Page<Foo> resultPage = service.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Foo>(
                Foo.class, uriBuilder, response, page, resultPage.getTotalPages(), size));

        return resultPage.getContent();
    }
}

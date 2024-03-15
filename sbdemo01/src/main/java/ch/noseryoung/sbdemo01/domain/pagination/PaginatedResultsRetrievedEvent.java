package ch.noseryoung.sbdemo01.domain.pagination;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.util.UriComponentsBuilder;

public class PaginatedResultsRetrievedEvent<T> extends ApplicationEvent {

    private UriComponentsBuilder uriBuilder;
    private HttpServletResponse response;
    private int page;
    private int totalPages;
    private int size;

    public PaginatedResultsRetrievedEvent(
            Class<T> fooClass,
            UriComponentsBuilder uriBuilder,
            HttpServletResponse response,
            int page, int totalPages, int size) {
        super(fooClass);
        this.uriBuilder = uriBuilder;
        this.response = response;
        this.page = page;
        this.totalPages = totalPages;
        this.size = size;
    }
}

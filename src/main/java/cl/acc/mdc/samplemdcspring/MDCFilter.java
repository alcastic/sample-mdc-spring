package cl.acc.mdc.samplemdcspring;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class MDCFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(MDCFilter.class);

    private static final String REQUEST_ID_PARAMETER = "requestId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        try {
            String requestIdParameter = request.getParameter(REQUEST_ID_PARAMETER);
            if (StringUtils.isEmpty(requestIdParameter)) {
                requestIdParameter = UUID.randomUUID().toString();
                log.info("Incoming request does not provides requestId. requestId={} has been assigned.",
                        requestIdParameter);
            }
            MDC.put("requestId", requestIdParameter);
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    @Override
    public void destroy() {

    }
}

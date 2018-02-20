package com.helloworld.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Component
public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 7;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.addZuulRequestHeader("my_zuul_request_header", "request_header");
        requestContext.addOriginResponseHeader("my_zuul_response_header", "response_header");
        requestContext.addZuulRequestHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwicm9sZSI6IlNZU1RFTV9BRE1JTiIsInByaXZpbGVnZXMiOlsiQ1JFQVRFX1VTRVIiLCJVUERBVEVfVVNFUiIsIlJFVFJJVkVfVVNFUiIsIkRFTEVURV9VU0VSIl0sImV4cCI6NjE1MTU2NDk1NzZ9.jP7P4c5tRGQfVyFlJA6Ac_mCOGUNXCtz7-iNY0NkdSWhia4g-mnAgEKWlZBDdfcrOD7vStxc9hSrW4i7Dmr9Yw");
        return null;
    }
}

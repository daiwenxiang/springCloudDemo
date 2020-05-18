package com.example.myzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class MyFilter1 extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //相同级别的filter之间的的执行顺序 数字越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //当前的filter是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //通过当前的上下文环境获得request等信息
        System.out.println("filter.......");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        System.out.println("uri"+request.getRequestURI());
        System.out.println("url"+request.getRequestURL());
        return null;
    }
}

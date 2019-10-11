package com.czk.apigeteway.filter;

import com.czk.apigeteway.constant.RedisConstant;
import com.czk.apigeteway.utils.CookiesUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;


/**
 * 权限拦截（区分卖家买家）
 * Created by ChenZK
 */
@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        /**
         * /order/create    只能买家访问（cookie有openid）
         * /order/finish    只能卖家访问（cookie有token，并且对应的redis有值）
         * /product/list    都可访问
         */
        if ("/order/create".equals(request.getRequestURI())) {
            Cookie cookies = CookiesUtil.get(request, "openid");
            if (cookies == null || StringUtils.isEmpty(cookies.getValue())){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        if ("/order/finish".equals(request.getRequestURI())){
            Cookie cookies = CookiesUtil.get(request, "token");
            if (cookies == null
                    || StringUtils.isEmpty(cookies.getValue())
                    || StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookies.getValue())))){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }

        return null;
    }
}

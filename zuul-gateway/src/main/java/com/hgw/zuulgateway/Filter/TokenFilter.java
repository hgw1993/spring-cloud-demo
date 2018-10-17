package com.hgw.zuulgateway.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

import javax.servlet.http.HttpServletRequest;

/**
 * created 2018/10/15
 * author  guangwei.huang
 */
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //定义filter的类型，有pre、route、post、error四种
        return "pre";
    }

    @Override
    public int filterOrder() {
        //定义filter的执行顺序，数字越小，越先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        String token = request.getParameter("token");
        if(StringUtils.isNotBlank(token)){
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(HttpStatus.SC_OK);
            ctx.set("isSuccess",true);
            return null;
        }else{
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(HttpStatus.SC_BAD_REQUEST);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess",false);
            return null;
        }
    }
}

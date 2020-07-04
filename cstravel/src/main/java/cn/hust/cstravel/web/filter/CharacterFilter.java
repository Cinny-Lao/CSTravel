package cn.hust.cstravel.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class CharacterFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        String method = req.getMethod();
        if(method.equalsIgnoreCase("post")){
            req.setCharacterEncoding("utf-8");
        }
        res.setContentType("text/html;charset=utf-8");
        chain.doFilter(req,res);
    }

    @Override
    public void destroy() {

    }
}

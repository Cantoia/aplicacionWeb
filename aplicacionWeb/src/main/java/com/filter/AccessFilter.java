package com.filter;


import com.model.Usuario;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jacobo on 27/11/14.
 */
public class AccessFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpRes = (HttpServletResponse) servletResponse;

        String urlEntera = httpReq.getRequestURL().toString();
        String url = urlEntera.substring(urlEntera.lastIndexOf("/")+1);

        Usuario user = new Usuario();
        user= (Usuario)httpReq.getAttribute("usuario");
        System.out.println(urlEntera);
        System.out.println(url);

        if(url.equals("agregarUsuario.do")){
            filterChain.doFilter(servletRequest,servletResponse);
        }

        if(isAjax(httpReq)){
            System.out.println("es ajax!");
            filterChain.doFilter(servletRequest,servletResponse);
        }

        if(url.equals("addUsuario.do")){
            System.out.println("se llegó al addusuario");
            filterChain.doFilter(servletRequest,servletResponse);
        }

        if(url.equals("login.do"))
            filterChain.doFilter(servletRequest,servletResponse);
/*        if(url.equals("login.do")){
            System.out.println("llegue al login");
            filterChain.doFilter(servletRequest,servletResponse);
        }else if(user==null){
            httpRes.sendRedirect("/login.do");
        } else {
            if(user.getIdUsuario().equals("jacodom"))
                filterChain.doFilter(servletRequest,servletResponse);
        }*/
    }


    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
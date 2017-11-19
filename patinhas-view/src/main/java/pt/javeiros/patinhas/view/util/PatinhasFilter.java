package pt.javeiros.patinhas.view.util;

import pt.javeiros.patinhas.util.FabricaConexao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = "/*")
public class PatinhasFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        FabricaConexao.getConnection();

        chain.doFilter(req, resp);

        FabricaConexao.closeConnection();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

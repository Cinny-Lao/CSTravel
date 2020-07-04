package cn.hust.cstravel.web.servlet;

import cn.hust.cstravel.domain.PageBean;
import cn.hust.cstravel.domain.Scheme;
import cn.hust.cstravel.service.SchemeService;
import cn.hust.cstravel.service.implement.SchemeServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/schemeServlet/*")
public class SchemeServlet extends BaseServlet {
    private SchemeService schemeService = new SchemeServiceI();


    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String cidStr = request.getParameter("cid");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String sname = request.getParameter("sname");
        sname = new String(sname.getBytes("iso-8859-1"),"utf-8");

        int cid = 0;
        if(cidStr!=null && cidStr.length()>0 && !"null".equals(cidStr)){
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 1;
        if(currentPageStr!=null && currentPageStr.length()>0){
            currentPage = Integer.parseInt(currentPageStr);
        }
        int pageSize = 5;
        if(pageSizeStr!=null && pageSizeStr.length()>0){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        PageBean<Scheme> pageBean = schemeService.pageQuery(cid, currentPage, pageSize, sname);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pageBean);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

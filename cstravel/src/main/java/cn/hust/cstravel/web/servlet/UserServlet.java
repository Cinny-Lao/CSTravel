package cn.hust.cstravel.web.servlet;

import cn.hust.cstravel.domain.ResultInfo;
import cn.hust.cstravel.domain.User;
import cn.hust.cstravel.service.UserService;
import cn.hust.cstravel.service.implement.UserServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/userServlet/*")
public class UserServlet extends BaseServlet {
    //声明UserService业务对象
    private UserService service = new UserServiceI();

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先验证验证码是否正确
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkCode.equalsIgnoreCase(code)){
            //验证码不正确
            ResultInfo info = new ResultInfo(false,"验证码错误");
            //将info转为json对象返回客户端
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        //获取参数（用户注册信息）
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service完成注册
        boolean register = service.register(user);
        ResultInfo info = new ResultInfo();
        if(register){
            //注册成功
            info.setFlag(true);
        }else{
            //注册不成功
            info.setFlag(false);
            info.setErrorMsg("该手机号用户已存在");
        }

        //将info转为json对象返回客户端
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    /**
     * 查重昵称
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean b = service.checkUsername(username);
        ResultInfo info = new ResultInfo();
        if(b){
            //昵称可用
            info.setFlag(true);
        }else{
            //昵称不可用
            info.setFlag(false);
            info.setErrorMsg("该昵称已被使用，请更换一个");
        }

        //将info转为json对象返回客户端
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //首先验证验证码是否正确
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkCode.equalsIgnoreCase(code)){
            //验证码不正确
            ResultInfo info = new ResultInfo(false,"验证码错误");
            //将info转为json对象返回客户端
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }
        //获取参数
        String loginname = request.getParameter("loginname");
        String password = request.getParameter("password");
        String reg = "1\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d";
        ResultInfo info = new ResultInfo();
        if(loginname.matches(reg)){
            //用户输入手机号登录
            User user = service.loginByTelAndPass(loginname, password);
            if(user!=null){
                //查询到用户，可登录
                info.setFlag(true);
                request.getSession().setAttribute("user",user);
            }else{
                //查询不到用户，不可登录
                info.setFlag(false);
                info.setErrorMsg("用户名或密码错误");
            }
        }else{
            //用户输入昵称登录
            User user = service.loginByUsernameAndPass(loginname, password);
            if(user!=null){
                //查询到用户，可登录
                info.setFlag(true);
                request.getSession().setAttribute("user",user);
            }else{
                //查询不到用户，不可登录
                info.setFlag(false);
                info.setErrorMsg("用户名或密码错误");
            }
        }
        //将info转为json对象返回客户端
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 查询已登录用户名
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findLoginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = (User)request.getSession().getAttribute("user");
        ResultInfo info = new ResultInfo();
        if(user==null){
            info.setFlag(false);
        }else{
            info.setFlag(true);
            info.setErrorMsg(user.getUsername());
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    /**
     * 用户账号退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"/index.html");
    }

}

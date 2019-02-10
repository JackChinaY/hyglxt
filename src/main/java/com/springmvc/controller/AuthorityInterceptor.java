package com.springmvc.controller;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 权限过滤
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

//    @Autowired
//    private PermissionSAO permissionSAOImpl;
//
//    @Value("#{configProperties['permissionLocalSwitch']}")
//    private String permissionLocalSwitch;
//
//    @Autowired
//    private IPermissionService permissionServiceImpl;
//
//    protected final Logger logger = Logger.getLogger(Constants.BUSINESS_LOG);

    private boolean noCheckAuthority = false;

    /**
     * 前置通知
     *
     * @param request
     * @param response
     * @param handler  表示的是被拦截的目标对象
     * @return
     * @throws IOException
     * http://localhost:8080/Demo2/user/loginIn
     * request.getContextPath():/Demo2
     * request.getRequestURI():/Demo2/user/loginIn
     * request.getServletPath():/user/loginIn
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("前置通知：" + request.getContextPath() + "   " + request.getRequestURI() + "   " + request.getServletPath());
        if (request.getServletPath().equals("/loginIn")) {
            System.out.println("用户请求：" + request.getServletPath() + " ，无需过滤");
            return true;
        } else {
            if (request.getSession().getAttribute("user") == null) {
                System.out.println("用户登录超时，需要重新登录");
//                response.sendRedirect(request.getContextPath() + "/relogin");
                response.sendRedirect(request.getContextPath() + "/");
                return false;
            }
        }
        return true;


//        try {
//            if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
//                Authority authority = ((HandlerMethod) handler).getMethodAnnotation(Authority.class);
//
//                if (noCheckAuthority) {
//                    return true;
//                }
//
//                if (authority == null || StringUtils.isEmpty(authority.value())) {
//                    //没有权限注解，或者权限注解为空
//                    response.sendRedirect(request.getContextPath() + "/authority/noeAuthority.do");
//                    return false;
//                }
//
//                //未登录可访问的资源
//                if (AuthorityConstant.LOGIN_NO_USER.equals(authority.value())) {
//                    return true;
//                }
//                //返回值：表示我们是否需要将当前的请求拦截下来
//                //如果为false，请求将被终止；如果为true，请求将继续
//                //从session获取当前登录用户信息
//                HttpSession session = request.getSession();
//                if (session.getAttribute(Constants.USER_SESSION_ARGUMENT) == null) {
//                    response.sendRedirect(request.getContextPath() + "/authority/noeLogin.do");
//                    return false;
//                }
//
//                //登录用户可访问的资源
//                if (AuthorityConstant.LOGIN_USER.equals(authority.value())) {
//                    return true;
//                }
//
//                //session用户信息
//                User sessionUser = (User) session.getAttribute(Constants.USER_SESSION_ARGUMENT);
//
//                boolean vote;
//                if ("1".equals(permissionLocalSwitch)) {
//                    //从本地获取权限信息
//                    logger.info("从本地系统获取权限信息");
//                    vote = permissionServiceImpl.vote(sessionUser.getUserId(), authority.value());
//                } else {
//                    //从远程权限模块调用权限信息
//                    logger.info("从远程权限系统获取权限信息");
//                    vote = permissionSAOImpl.vote(sessionUser.getUserId(), authority.value());
//                }
//
//
//                if (vote) {
//                    //System.out.println("1111");
//                    return true;
//                } else {
//
//                    response.sendRedirect(request.getContextPath() + "/authority/noeAuthority.do");
//                    return false;
//                }
//            }
//            return super.preHandle(request, response, handler);
//
//        } catch (Exception e) {
//            logger.error("权限判断异常", e);
//            response.sendRedirect(request.getContextPath() + "/authority/errorAuthority.do");
//            return false;
//        }
    }
}

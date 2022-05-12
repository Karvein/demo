package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Service.impl.AdminServiceImpl;
import com.example.demo.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;


/**
 * 1. Controller, RestController的共同点
 *
 * 都是用来表示Spring某个类的是否可以接收HTTP请求。
 *
 * 2. Controller, RestController的不同点
 *
 * @Controller：标识一个Spring类是Spring MVC controller处理器,
 * @RestController：@RestController是@Controller和@ResponseBody的结合体，
 * 两个标注合并起来的作用。@Controller类中的方法可以直接通过返回String跳转到jsp、ftl、html等模版页面。在方法上加@ResponseBody注解，也可以返回实体对象。@RestController类中的所有方法只能返回String、Object、Json等实体对象，不能跳转到模版页面。Linux就该这么学
 *
 * @RestController中的方法如果想跳转页面，则用ModelAndView进行封装
 *
 * @RestController
 * public class UserController {
 *
 *     @RequestMapping(value = "/index",method = RequestMethod.GET)
 *     public String toIndex(){
 *         ModelAndView mv = new ModelAndView("index");
 *       	return mv;
 *     }
 * }
 *
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
    // 管理员控制接口
    // 依赖注入到服务接口调用
    @Resource
    private AdminServiceImpl adminServiceImpl;

    // 此处代码有误,无法解析前端传输的string
    @RequestMapping("/login")
    public String findAdmin(String json) {
        // 接收json输入,按照传输进入的数据转化为vo类,再返回json结果
        System.out.println(json);
        UserVo uservo = JSON.parseObject(json, UserVo.class);
        if (!(adminServiceImpl.findAdmin(uservo.getUser_name(), uservo.getUser_password()).getUserId() >= 0)) {
            return "success";
        } else {
            return "fail";
        }
    }
//    @RequestMapping("/login")
//    public String findAdmin(@RequestParam String name ,@RequestParam String pwd) {
//        adminServiceImpl.findAdmin(name,pwd);
        // ThreadLocal RequestContextHolder
//        // 获取相关对象
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//
//        // 底层实现：request.getAttribute("userId");
//        String userId = (String) requestAttributes.getAttribute("userId",RequestAttributes.SCOPE_REQUEST);
//
//        // 底层实现：session.getAttribute("userId");
//        String userId = (String) requestAttributes.getAttribute("userId",RequestAttributes.SCOPE_SESSION);
//
//        // 或者转成具体对象
//        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
//        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
//        HttpSession session = request.getSession();
//        Serializable

//        // 重定向失败
//        return "redirect:/users/findAll";
//    }
}

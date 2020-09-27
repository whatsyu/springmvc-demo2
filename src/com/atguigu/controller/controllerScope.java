package com.atguigu.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
//@SessionAttributes(types ={Integer.class})
public class controllerScope {

    @RequestMapping("requestScope")
    public String test1(HttpServletRequest request){
        System.out.println("requestScope");
        request.setAttribute("a","小明");
        request.setAttribute("b","小红");
        return "ok";
    }

    @RequestMapping("servletContext")
    public String test2(HttpSession session){
        System.out.println("servletContext");
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("c","111");
        servletContext.setAttribute("d","222");
        return "ok";
    }

    @RequestMapping("mapToRequest")
    public String test3(Map<String,Object>map){
        System.out.println("map");
        map.put("e",333);
        map.put("f",444);
        return "ok";
    }

    @RequestMapping("modelAndView")
    public ModelAndView test4(ModelAndView modelAndView){
//        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("g","123");
        modelAndView.setViewName("ok");
        return modelAndView;
    }
}

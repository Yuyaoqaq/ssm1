package com.cy.web.controller.user;

import com.cy.service.UserService;
import com.cy.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login.do")
    public ResultData userLogin(HttpServletRequest req,String username,String password){
        //accept
        //service
        ResultData resultData = userService.findUserByLogin(username,password);
        System.out.println(resultData.getData());
        if(resultData.getCode()==0){
            HttpSession session = req.getSession();
            session.setAttribute("user",resultData.getData());
        }
        //response
        return resultData;
    }
}

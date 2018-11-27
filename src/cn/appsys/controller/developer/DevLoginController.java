package cn.appsys.controller.developer;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: xucunxin
 * @date: 2018/11/27
 * @package cn.appsys.controller.developer
 * @description: TODO
 */
@Controller
@RequestMapping(value = "/dev")
public class DevLoginController {
    @Resource
    private DevUserService service;
    private Logger logger=Logger.getLogger(DevLoginController.class);

    @RequestMapping(value = "/login")
    public String Login(){
        return "devlogin";
    }

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String doLogin(@RequestParam String devCode,
                          @RequestParam String devPassword,
                          HttpServletRequest request,
                          HttpSession session){
        logger.info("doLogin>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info("\n\nName:"+devCode+"\t"+devPassword+"\n\n");
        DevUser user=null;
       try {
           user=service.login(devCode,devPassword);
       }catch (Exception e){
           e.printStackTrace();
       }
        if (null !=user) {
            //放入session中
            session.setAttribute(Constants.DEV_USER_SESSION,user);
            //页面跳转（main.jsp）
            return "redirect:/dev/flatform/main";
        }else{
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "用户名或密码不正确");
            return "devlogin";
        }
    }

    @RequestMapping("/flatform/main")
    public String uu(HttpSession session){
        if(session.getAttribute(Constants.DEV_USER_SESSION )== null){
            return "redirect:/dev/login";
        }
        return "developer/main";
    }
}

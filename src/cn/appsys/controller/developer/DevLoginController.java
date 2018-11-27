package cn.appsys.controller.developer;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

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
    private DevUserService devUserService;
    private Logger logger=Logger.getLogger(DevLoginController.class);
    @RequestMapping(value = "/login")
    public String Login(){
        return "devlogin";
    }

}

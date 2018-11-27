package cn.appsys.service.developer;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: xucunxin
 * @date: 2018/11/27
 * @package cn.appsys.service.developer
 * @description: TODO
 */
@Service
public class DevUserServicelmpl implements DevUserService{
    @Resource
    private DevUserMapper devUserMapper;
    @Override
    public DevUser login(String devCode, String devPassword) throws Exception {
        DevUser devUser=null;
        if(null!=devUser){
            if(!devUser.getDevPassword().equals(devPassword)){
                devUser=null;
            }
        }
        return devUser;
    }
}

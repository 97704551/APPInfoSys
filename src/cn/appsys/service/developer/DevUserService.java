package cn.appsys.service.developer;

import cn.appsys.pojo.DevUser;

/**
 * @author: xucunxin
 * @date: 2018/11/27
 * @package cn.appsys.service.developer
 * @description: TODO
 */
public interface DevUserService {
    public DevUser login(String devCode, String devPassword) throws Exception;
}

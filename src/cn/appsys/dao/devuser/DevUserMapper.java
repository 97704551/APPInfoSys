package cn.appsys.dao.devuser;

import cn.appsys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author: xucunxin
 * @date: 2018/11/26
 * @package cn.appsys.dao.devuser
 * @description: TODO
 */
public interface DevUserMapper {
    //�û�����ƽ̨��¼
    public DevUser getLoginUser(@Param("devCode") String devCode)throws Exception;
}

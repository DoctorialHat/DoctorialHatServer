package ga.bazinga.DoctorialHatServer.Controller;

import ga.bazinga.DoctorialHatServer.Entity.UserInfo;
import ga.bazinga.DoctorialHatServer.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/DoctorialHat/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoRepository userInfoRepository;

    //获取全部用户详细信息
    @RequestMapping(method = RequestMethod.GET)
    public List<UserInfo> getAllUserInfo(){
        return userInfoRepository.findAll();
    }

    //通过手机号获取单个用户的详细信息
    @RequestMapping(method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam String phone){
        return userInfoRepository.findByUserPhone(phone);
    }

    //添加用户详细信息

}

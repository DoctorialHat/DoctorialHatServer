package ga.bazinga.DoctorialHatServer.Controller;

import ga.bazinga.DoctorialHatServer.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoRepository userInfoRepository;


}

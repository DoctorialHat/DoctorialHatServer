package ga.bazinga.DoctorialHatServer.Controller;

import ga.bazinga.DoctorialHatServer.Repository.UserInfoRepository;
import ga.bazinga.DoctorialHatServer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;


}

package ga.bazinga.DoctorialHatServer.Controller;

import ga.bazinga.DoctorialHatServer.Entity.User;
import ga.bazinga.DoctorialHatServer.Entity.UserInfo;
import ga.bazinga.DoctorialHatServer.Repository.UserInfoRepository;
import ga.bazinga.DoctorialHatServer.Repository.UserRepository;
import ga.bazinga.DoctorialHatServer.Security.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/DoctorialHat/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    //当Client请求全部用户信息的时候返回全部用户信息
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //当Client发送一个注册请求的时候
    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfoRepository.insert(userInfo);
        return userRepository.insert(user);
    }

    //当Client登录的时候，请求用户名，返回整个User Object
    @RequestMapping(method = RequestMethod.GET)
    public User getUserByPhone(@RequestParam String phone){
        return userRepository.findByPhone(phone);
    }

    //当Client修改手机号的时候，通过id修改手机号
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String id, @RequestParam String newPhone){
        Optional<User> userOptional = userRepository.findById(id);
        User user;
        if(userOptional.isPresent()){
            user = userOptional.get();
            String oldPhone = user.getPhone();
            UserInfo userInfo = userInfoRepository.findByUserPhone(oldPhone);
            user.setPhone(newPhone);
            userInfo.setUser(user);
            userRepository.save(user);
            userInfoRepository.save(userInfo);
        } else{
            return null;
        }
        return user;
    }

    //当Client修改密码的时候，通过id查询用户然后修改其密码
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public User updateUserByPassword(@PathVariable String id, @RequestParam String newPassword){
        Optional<User> userOptional = userRepository.findById(id);
        User user;
        if(userOptional.isPresent()){
            //对user集合的修改
            user = userOptional.get();
            user.setPassword(newPassword);
            userRepository.save(user);

            //对userInfo集合的修改
            String oldPhone = user.getPhone();
            UserInfo userInfo = userInfoRepository.findByUserPhone(oldPhone);
            userInfo.setUser(user);
            userInfoRepository.save(userInfo);
        } else{
            return null;
        }
        return user;
    }

    //当Client被管理员封禁的时候，删除账号
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }

}

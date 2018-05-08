package ga.bazinga.DoctorialHatServer.Controller;

import ga.bazinga.DoctorialHatServer.Entity.User;
import ga.bazinga.DoctorialHatServer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/DoctorialHat/user")
public class UserController {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    //当Client请求全部用户信息的时候返回全部用户信息
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //当Client发送一个注册请求(只有用户名和密码)的时候
    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        String phone = user.getPhone();

        //去重
        if(userRepository.findByPhone(phone) != null){
            return userRepository.findByPhone(phone);
        } else{
            //设置一个默认的昵称和个性签名
            user.setNickName("昵称未设置");
            user.setDescription("个人简介未设置");

            return userRepository.insert(user);
        }

    }


    //当Client登录的时候，请求用户名，返回整个User Object
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUserByPhone(@RequestParam(value = "phone") String phone){
        return userRepository.findByPhone(phone);
    }

    //Client修改信息
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String id,@RequestBody User postUser){
        Optional<User> userOptional = userRepository.findById(id);
        User newUser;
        if(userOptional.isPresent()){
            String postPhone = postUser.getPhone();
            String postPassword = postUser.getPassword();
            String postNickName = postUser.getNickName();
            String postDescription = postUser.getDescription();
            newUser = userOptional.get();

            if(postPhone != null){
                newUser.setPhone(postPhone);
            }
            if(postPassword != null){
                newUser.setPassword(postPassword);
            }
            if(postNickName != null){
                newUser.setNickName(postNickName);
            }
            if(postDescription != null){
                newUser.setDescription(postDescription);
            }

            userRepository.save(newUser);
        } else{
            return null;
        }
        return newUser;
    }


    //当Client被管理员封禁的时候，删除账号
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }

}

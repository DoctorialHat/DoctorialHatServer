package ga.bazinga.DoctorialHatServer.Controller;

import ga.bazinga.DoctorialHatServer.Entity.BugReflect;
import ga.bazinga.DoctorialHatServer.Repository.BugReflectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/DoctorialHat/bug")
public class BugReflectController {
    @Autowired
    private BugReflectRepository bugReflectRepository;

    //Client上传了一个问题反馈
    @RequestMapping(method = RequestMethod.POST)
    public BugReflect addBug(@RequestBody BugReflect bugReflect){
        return bugReflectRepository.insert(bugReflect);
    }

    //Client获取全部的Bug反馈
    @RequestMapping(method = RequestMethod.GET)
    public List<BugReflect> getAllBug(){
        return bugReflectRepository.findAll();
    }

}

package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.entity.User;
import moe.keshane.gradleblog.dal.UserRepo;
import moe.keshane.gradleblog.service.interfaces.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegServiceImpl implements RegService {

    @Autowired
    UserRepo userRepo;

    @Override
    public boolean reg(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            userRepo.save(user);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

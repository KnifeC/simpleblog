package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.UserRepo;
import moe.keshane.gradleblog.dal.entity.User;
import moe.keshane.gradleblog.service.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepo userRepo;

    @Override
    public User login(String username, String password) {
        try {
            User user = userRepo.findByUsernameAndPassword(username, password);
            return user;
        }catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.UserRepo;
import moe.keshane.gradleblog.dal.entity.User;
import moe.keshane.gradleblog.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public User findUserByUserid(int userid) {
        try {
            User user = userRepo.findOneByUserid(userid);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

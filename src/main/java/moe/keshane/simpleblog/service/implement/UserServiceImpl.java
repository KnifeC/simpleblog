package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.UserRepo;
import moe.keshane.simpleblog.dal.entity.User;
import moe.keshane.simpleblog.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int getUserCount() {
        List<User> all = userRepo.findAll();
        int size = all.size();
        return size;
    }
}

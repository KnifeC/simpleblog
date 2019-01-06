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
    public User reg(User user) {
        try {
            userRepo.save(user);
            return user;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

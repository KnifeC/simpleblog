package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.UserRepo;
import moe.keshane.simpleblog.dal.entity.User;
import moe.keshane.simpleblog.service.interfaces.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserServiceImpl implements UpdateUserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public boolean updateUser(User user) {
        try{
            userRepo.save(user);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
}

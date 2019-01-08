package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.UserRepo;
import moe.keshane.simpleblog.dal.entity.User;
import moe.keshane.simpleblog.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepo userRepo;
    @Override
    public ArrayList<User> getAllUserInfo() {
        try{
            ArrayList<User> all = (ArrayList<User>)userRepo.findAll();
            return all;
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

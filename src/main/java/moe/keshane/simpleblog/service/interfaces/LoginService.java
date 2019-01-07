package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.User;

public interface LoginService {
    User login(String username , String password);
}

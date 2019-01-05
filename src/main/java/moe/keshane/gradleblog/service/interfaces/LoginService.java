package moe.keshane.gradleblog.service.interfaces;

import moe.keshane.gradleblog.dal.entity.User;

public interface LoginService {
    User login(String username , String password);
}

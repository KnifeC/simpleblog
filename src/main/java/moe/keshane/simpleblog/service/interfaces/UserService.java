package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.User;

public interface UserService {
    User findUserByUserid(int userid);
}

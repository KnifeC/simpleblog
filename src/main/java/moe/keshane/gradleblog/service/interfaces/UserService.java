package moe.keshane.gradleblog.service.interfaces;

import moe.keshane.gradleblog.dal.entity.User;

public interface UserService {
    User findUserByUserid(int userid);
}

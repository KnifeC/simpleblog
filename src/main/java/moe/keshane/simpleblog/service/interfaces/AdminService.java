package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Article;
import moe.keshane.simpleblog.dal.entity.User;

import java.util.ArrayList;

public interface AdminService {
    ArrayList<User> getAllUserInfo();
}

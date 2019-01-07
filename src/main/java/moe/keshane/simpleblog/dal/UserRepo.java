package moe.keshane.simpleblog.dal;


import moe.keshane.simpleblog.dal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsernameAndPassword(String username,String password);
    User findOneByUserid(int userid);
}

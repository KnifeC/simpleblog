package moe.keshane.gradleblog.dal;


import moe.keshane.gradleblog.dal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsernameAndPassword(String username,String password);
    User findOneByUserid(int userid);
}

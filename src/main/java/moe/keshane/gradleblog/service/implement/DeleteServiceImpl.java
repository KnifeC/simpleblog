package moe.keshane.gradleblog.service.implement;

import moe.keshane.gradleblog.dal.ArticleRepo;
import moe.keshane.gradleblog.service.interfaces.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteServiceImpl implements DeleteService {

    @Autowired
    ArticleRepo articleRepo;

    @Override
    public boolean deleteArticleById(int articleid) {
        try{
            articleRepo.deleteById(articleid);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
}

package moe.keshane.simpleblog.service.implement;

import moe.keshane.simpleblog.dal.ImageRepo;
import moe.keshane.simpleblog.dal.entity.Image;
import moe.keshane.simpleblog.service.interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepo imageRepo;

    @Override
    public Image uploadImage(int userid, String imageUrl, String deleteUrl) {
        Image image = new Image();
        image.setUploaddate(new Date());
        image.setDeleteurl(deleteUrl);
        image.setUserid(userid);
        image.setImageurl(imageUrl);
        try {
            imageRepo.save(image);
            return image;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Image> getAllImage() {
        try {
            ArrayList<Image> allByOrderByUploaddateDesc = imageRepo.findAllByOrderByUploaddateDesc();
            return allByOrderByUploaddateDesc;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

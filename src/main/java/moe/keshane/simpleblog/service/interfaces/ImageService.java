package moe.keshane.simpleblog.service.interfaces;

import moe.keshane.simpleblog.dal.entity.Image;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;


public interface ImageService {
    Image uploadImage(int userid,String imageUrl,String deleteUrl);
    ArrayList<Image> getAllImage();

}

package moe.keshane.simpleblog.dal;

import moe.keshane.simpleblog.dal.entity.Image;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface ImageRepo extends PagingAndSortingRepository<Image,Integer> {
    ArrayList<Image> findAllByOrderByUploaddateDesc();
}

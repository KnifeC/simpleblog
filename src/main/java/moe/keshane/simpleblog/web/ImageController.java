package moe.keshane.simpleblog.web;


import com.google.gson.Gson;
import com.youbenzi.mdtool.tool.MDTool;
import moe.keshane.simpleblog.common.SessionKey;
import moe.keshane.simpleblog.dal.entity.Image;
import moe.keshane.simpleblog.service.interfaces.ImageService;
import moe.keshane.simpleblog.web.returnset.ReturnImageJson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

@Controller
public class ImageController {

    String requestURL = "https://sm.ms/api/upload";
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/image",method = RequestMethod.GET)
    public String photo(HttpSession session, ModelMap modelMap){
        Object username = session.getAttribute(SessionKey.USER_NAME);
        Object usertype = session.getAttribute(SessionKey.USER_TYPE);
        if(usertype!=null&&usertype.toString().equals("admin")){
            modelMap.put("adminpermission",true);
        }
        modelMap.put("username",username);
        ArrayList<Image> allImage = imageService.getAllImage();
        ArrayList<String> image_here = new ArrayList<>();
        for(Image i :allImage){
            image_here.add(MDTool.markdown2Html("![]("+i.getImageurl()+")"));
        }
        modelMap.put("image_here",image_here);
        return "imagemanage";
    }



    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public String photo(MultipartFile imagefile,HttpSession session){
        String json = gosmms(imagefile);
        Gson gson = new Gson();
        try {
            ReturnImageJson returnImageJson = gson.fromJson(json, ReturnImageJson.class);
            Image image = imageService.uploadImage((int) session.getAttribute(SessionKey.USER_ID), returnImageJson.data.url, returnImageJson.data.delete);
            if(image!=null) {
                return "redirect:/image";
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    String gosmms(MultipartFile imagefile)
    {
        String fileName = imagefile.getOriginalFilename();
        //上传到sm.ms
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(50000)
                .setSocketTimeout(50000)
                .setConnectionRequestTimeout(10000)
                .build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config)
                .setRetryHandler(new DefaultHttpRequestRetryHandler())
                .setUserAgent("Mozilla/5.0(Windows;U;Windows NT 5.1;en-US)")
                .build();
        HttpPost post = new HttpPost(requestURL);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        try {
            builder.addBinaryBody("smfile", imagefile.getInputStream(), ContentType.MULTIPART_FORM_DATA, fileName);
            HttpEntity entity = builder.build();
            post.setEntity(entity);
            HttpResponse response = httpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                String result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}

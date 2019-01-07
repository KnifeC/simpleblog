package moe.keshane.simpleblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController {

    @RequestMapping(value = "/e",method = RequestMethod.GET)
    public String error(ModelMap modelMap,HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        if(status == null){
//            modelMap.put("error_type","emmm");
//            modelMap.put("error_message","There's Something Wrong")
//        }
//        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        return "error";
    }
}

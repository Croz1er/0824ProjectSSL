package com.deer.qx.controller.leave;

import com.deer.ljy.pojo.User;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.model.info.Affiche;
import com.deer.qx.service.leave.AfficheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/affiche")
public class AfficheController {
    @Autowired
    private AfficheService afficheService;
    @RequestMapping("/findAll.do")
    public BaseResult findAll()throws Exception{
        List<Affiche> list = afficheService.findAll();
        BaseResult result=new BaseResult();
        if (!list.isEmpty()){
            result.setData(list);
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    @RequestMapping("/add.do")
    public BaseResult add(Affiche affiche, HttpSession session)throws Exception{
        BaseResult result= new BaseResult();
        affiche.setStartTime(new Date());
        User sessionUser =(User) session.getAttribute("sessionUser");
        affiche.setPublisher(sessionUser.getUsername());affiche.setEndTime(new Date(new Date().getTime()+(60*60*24*3)));
        int i = afficheService.insertAffiche(affiche);
        if (i>0){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    @RequestMapping("/remove.do")
    public BaseResult remove(int id)throws Exception{
        System.out.println(id);
        BaseResult result= new BaseResult();
        int i = afficheService.deleteById(id);
        if(i>0){
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }
    }

    @RequestMapping("/update.do")
    public BaseResult update(Affiche affiche)throws Exception{
        BaseResult result= new BaseResult();
        int i = afficheService.updateAffiche(affiche);
        if (i>0){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

}

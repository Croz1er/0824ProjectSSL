package com.deer.qx.controller.leave;

import com.deer.ljy.pojo.base.BaseResult;
import com.deer.qx.mapper.leave.InformationMapper;
import com.deer.qx.model.info.Information;

import com.deer.qx.service.leave.InformationService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/info")
public class InformationController {

    public String pictureName=null ;
    public String picturePath=null ;

    @Autowired
    private InformationService informationService;

    @Autowired
    private InformationMapper informationMapper;

    @RequestMapping("/findAll.do")
    public BaseResult findAll()throws Exception{
        List<Information> list = informationService.findAll();
        System.out.println(list+"_______________________");
        BaseResult result=new BaseResult();
        if (!list.isEmpty()){
            result.setData(list);
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    //上传文件
    @RequestMapping("/add.do")
    public BaseResult add(Information information, HttpServletRequest request,@RequestParam("file") MultipartFile multipartFile )throws Exception{
        BaseResult result= new BaseResult();

        String path = "E:\\SL\\src\\main\\resources\\static\\page\\upload";

        File file = new File(path);

        information.setFileSize((int)multipartFile.getSize());
        information.setFileName(multipartFile.getOriginalFilename());
        //路径
        information.setFilePath(path);
        String[] split = multipartFile.getContentType().split("/");
        information.setTypeName(split[1]);
        information.setTypeId(0);
        information.setPublishTime(new Date());
        information.setState(1);

        int i = informationMapper.insertInformationAndFile(information);
        if(i>0){
            multipartFile.transferTo(new File("E:\\SL\\src\\main\\resources\\static\\page\\upload",multipartFile.getOriginalFilename()));
            result.setCode(0);
            return result;
        }else {
            result.setCode(1);
            return result;
        }

//        System.out.println("=================================");
//        System.out.println(multipartFile.getName());
//        //获取文件大小
//        System.out.println(multipartFile.getSize());
//        //获取文件名
//        System.out.println(multipartFile.getOriginalFilename());
//        //文件类型
//        System.out.println(multipartFile.getContentType());
//        System.out.println(multipartFile.getBytes());
//        System.out.println(multipartFile.getResource());
//        System.out.println(multipartFile.getInputStream());
//        System.out.println("=================================");


    }

    //下载文件
    @RequestMapping("/down.do")
    public ResponseEntity<byte[]> download(String filename) throws  Exception{

        System.out.println(filename);
        String path = "E:\\SL\\src\\main\\resources\\static\\page\\upload";
        String downloadpath = path + "\\"+filename;
        File file = new File(downloadpath);

        if(file.exists()){
            byte[] bytes = FileUtils.readFileToByteArray(file);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Disposition","attachment;filename="+filename);
            HttpStatus ok = HttpStatus.OK;
            return new ResponseEntity<>(bytes,httpHeaders,ok);
        }else {
            return null;
        }
    }


    @RequestMapping("/remove.do")
    public BaseResult remove(int id)throws Exception{
        BaseResult result= new BaseResult();
        informationService.deleteById(id);
        result.setCode(0);
        return result;
    }


}

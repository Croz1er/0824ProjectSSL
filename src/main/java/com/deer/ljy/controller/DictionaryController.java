package com.deer.ljy.controller;

import com.deer.ljy.pojo.Dictionary;
import com.deer.ljy.pojo.base.BaseResult;
import com.deer.ljy.service.DictionaryService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Resource
    private DictionaryService service;

    /**
     * 查询所有字典
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAllDictionary.do")
    public BaseResult<List<Dictionary>> findAllDictionary(int page,int limit) {
        BaseResult<List<Dictionary>> result = new BaseResult<>();
        List<Dictionary> allDict = service.findAllDict(page, limit);
        int total = (int) PageInfo.of(allDict).getTotal();
        result.setCode(0);
        result.setCount(total);
        result.setData(allDict);
        return result;
    }

    /**
     * 通过id查询字典,获取值的名称
     * @param id
     * @return
     */
    @RequestMapping("/findDicById.do")
    public BaseResult<String> findDictionaryById(int id) {
        BaseResult<String> result = new BaseResult<>();
        Dictionary dictionary = service.selectDictById(id);
        if (dictionary!=null){
            result.setCode(0);
            result.setData(dictionary.getValueName());
        }
        return result;
    }

    /**
     * 添加字典
     * @param dictionary
     * @return
     */
    @RequestMapping("/addDict.do")
    public BaseResult addDictionary(Dictionary dictionary) {
        BaseResult result = new BaseResult();
        int i = service.addDictionary(dictionary);
        if (i>0){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    /**
     * 更新字典
     * @param dictionary
     * @return
     */
    @RequestMapping("/updateDict.do")
    public BaseResult updateDictionary(Dictionary dictionary) {
        BaseResult result = new BaseResult();
        int i = service.changeDictionary(dictionary);
        if (i>0){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }

    /**
     * 通过数组删除字典
     * @param ids
     * @return
     */
    @RequestMapping("removeDict.do")
    public BaseResult delteDictionary(@Param("ids") int [] ids) {
        BaseResult result = new BaseResult();

        String dictionary = service.removeDictionary(ids);
        if (dictionary == null){
            result.setCode(0);
        }else {
            result.setCode(1);
            result.setMsg(dictionary);
        }
        return result;
    }


}

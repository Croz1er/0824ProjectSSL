package com.deer.ljy.service;

import com.deer.ljy.mapper.DictionaryMapper;
import com.deer.ljy.pojo.Dictionary;
import com.deer.ljy.pojo.Role;
import com.deer.ljy.pojo.User;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Resource
    private UserService userService;

    @Override
    public List<Dictionary> findAllDict(int page,int limit) {
        PageHelper.startPage(page, limit);
        return dictionaryMapper.selectAllDict();
    }

    @Override
    public List<Dictionary> findDictByType(String typeCode) {
        return dictionaryMapper.selectDictByType(typeCode);
    }

    @Override
    public Dictionary selectDictById(Integer id) {
        return dictionaryMapper.selectDictById(id);
    }

    @Transactional
    @Override
    public int changeDictionary(Dictionary dictionary) {
        return dictionaryMapper.updateDictionary(dictionary);
    }

    @Transactional
    @Override
    public String removeDictionary(int [] ids) {
        for (Integer id : ids) {
            List<User> allUser = userService.findAllUser();
            System.out.println("======================"+allUser);
            Dictionary dictionary = selectDictById(id);
            System.out.println("======"+dictionary.getValueName());

            for (User user : allUser) {
                System.out.println("======"+user);
                if (user.getCardTypeName().equals(dictionary.getValueName())||user.getSex().equals(dictionary.getValueName())){
                    return new String("字典编号:" + id + "号,未删除成功,正在被使用");
                }
            }
            int i = dictionaryMapper.deleteDictionary(id);
            if (i <= 0) {
                return new String("字典编号:" + id + "号,未删除成功");
            }
        }
        return null;
    }

    @Transactional
    @Override
    public int addDictionary(Dictionary dictionary) {
        return dictionaryMapper.insertDictionary(dictionary);
    }
}

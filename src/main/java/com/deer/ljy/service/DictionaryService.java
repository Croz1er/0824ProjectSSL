package com.deer.ljy.service;

import com.deer.ljy.pojo.Dictionary;

import java.util.List;

public interface DictionaryService {


    List<Dictionary> findAllDict(int page,int limit);

    List<Dictionary> findDictByType(String typeCode);

    Dictionary selectDictById(Integer id);

    int changeDictionary(Dictionary dictionary);

    String removeDictionary(int[] ids);

    int addDictionary(Dictionary dictionary);

}

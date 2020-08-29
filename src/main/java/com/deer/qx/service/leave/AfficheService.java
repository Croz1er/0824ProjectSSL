package com.deer.qx.service.leave;

import com.deer.qx.model.info.Affiche;

import java.util.List;

public interface AfficheService {

    List<Affiche> findAll()throws Exception;

    int insertAffiche(Affiche affiche)throws Exception;

    int deleteById(int id)throws Exception;

    int updateAffiche(Affiche affiche)throws Exception;
}

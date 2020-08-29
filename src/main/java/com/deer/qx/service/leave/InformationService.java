package com.deer.qx.service.leave;

import com.deer.qx.model.info.Information;

import java.util.List;

public interface InformationService {
    List<Information> findAll() throws  Exception;

    int insertInformation(Information information) throws Exception;

    int  deleteById(int id) throws Exception;
}

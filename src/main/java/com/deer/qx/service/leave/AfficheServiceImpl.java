package com.deer.qx.service.leave;

import com.deer.qx.mapper.leave.AfficheMapper;
import com.deer.qx.model.info.Affiche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AfficheServiceImpl implements AfficheService {
    @Autowired
    private AfficheMapper afficheMapper;
    @Override
    public List<Affiche> findAll() throws Exception {
        return afficheMapper.findAll();
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int insertAffiche(Affiche affiche) throws Exception {
        return afficheMapper.insertAffiche(affiche);
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public int deleteById(int id) throws Exception {
        return afficheMapper.deleteById(id);
    }

    @Override
    @Transactional
    public int updateAffiche(Affiche affiche) throws Exception {
        return afficheMapper.updateAffiche(affiche);
    }
}

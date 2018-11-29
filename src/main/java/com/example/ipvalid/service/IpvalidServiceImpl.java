package com.example.ipvalid.service;

import com.example.ipvalid.dao.IpvalidDao;
import com.example.ipvalid.domain.Ipvalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpvalidServiceImpl implements IIPvalidService {
    @Autowired
    private IpvalidDao dao;

    @Override
    public void add(Ipvalid ipvalid){
        dao.add(ipvalid);
    }
    public List<Ipvalid> get(long id){
        return dao.get(id);
    }
    public List<Ipvalid> getAll(){
        return dao.getAll();
    }
    public boolean delete(long id){
        return dao.delete(id);
    }
    public boolean update(Ipvalid ipvalid){

        return dao.update(ipvalid);
    }
}

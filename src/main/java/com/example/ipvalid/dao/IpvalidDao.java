package com.example.ipvalid.dao;


import com.example.ipvalid.domain.Ipvalid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IpvalidDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Ipvalid ipvalid){
        jdbcTemplate.update("insert into ipvalid(ipaddress,status) values(?,?)",ipvalid.getIpAddress(),ipvalid.getStatus());
    }

    public  List<Ipvalid> get(long id){
        RowMapper<Ipvalid> rowMapper= new BeanPropertyRowMapper<Ipvalid>(Ipvalid.class);
        Ipvalid ipvalid=jdbcTemplate.queryForObject("select * from ipvalid where id=?",rowMapper,id);
        List<Ipvalid> list = new ArrayList<>();
        list.add(ipvalid);
        return list;
    }

    public List<Ipvalid> getAll(){
        RowMapper<Ipvalid> rowMapper= new BeanPropertyRowMapper<Ipvalid>(Ipvalid.class);
        List<Ipvalid> list=jdbcTemplate.query("select * from ipvalid",rowMapper);
        return list;
    }

    public boolean  delete(long id){
        int count = jdbcTemplate.update("delete from ipvalid where id=?",id);
        if(count!=0) {
            return true;
        }
        return false;
    }

    public boolean update(Ipvalid ipvalid){
        int count = jdbcTemplate.update("update ipvalid set ipaddress=?,status=? where id=?",ipvalid.getIpAddress(),ipvalid.getStatus(),ipvalid.getId());
        if(count!=0) {
            return true;
        }
        return false;
    }


}

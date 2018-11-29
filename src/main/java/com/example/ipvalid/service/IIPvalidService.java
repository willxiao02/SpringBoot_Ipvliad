package com.example.ipvalid.service;

import com.example.ipvalid.domain.Ipvalid;

import java.util.List;

public interface IIPvalidService {
    void add(Ipvalid ipvalid);
    List<Ipvalid> get(long id);
    List<Ipvalid> getAll();
    boolean delete(long id);
    boolean update(Ipvalid ipvalid);
}

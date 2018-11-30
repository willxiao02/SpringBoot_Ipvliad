package com.example.ipvalid.controller;


import com.example.ipvalid.domain.Ipvalid;
import com.example.ipvalid.service.IIPvalidService;
import com.example.ipvalid.service.IPUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ip")
public class IpvalidController {

    private static final Log log = LogFactory.getLog(Ipvalid.class);
    public final static List STATUSLIST = Arrays.asList("STOPPED", "BOOTING","STARTED");

    @Autowired
    private IIPvalidService iiPvalidService;

    @RequestMapping("/add")
    public String add(String ip,String status){

        if(log.isTraceEnabled()){
            log.trace("add is called"+ ip + status);
        }

        IPUtils ipUtils = new IPUtils();
        if (!ipUtils.isIP(ip))
        {
            return "ip format not correct";
        }
        status=status.toUpperCase().trim();
        if(!STATUSLIST.contains(status)){
            return "status error,The status could be one of the following:\n" +
                    "STOPPED, BOOTING, STARTED.";
        }
        switch (status){
            case "STOPPED": status = "1";break;
            case "BOOTING": status = "2";break;
            case "STARTED": status = "3";break;
            default : status = "0"; break;
        }

        try{
            long tip = IPUtils.getIpFromString(ip);
            Ipvalid ipvalid = new Ipvalid(tip,status);
            iiPvalidService.add(ipvalid);
            Thread.sleep(4000);
            return "add successfully";

        }
        catch(Exception e){
            return "add record abend:"+e.toString();
        }
    }

    @RequestMapping("/get")
    public List<String> get(long id){
        if(log.isTraceEnabled()){
            log.trace("get is called"+ id);
        }
        List<Ipvalid> list = iiPvalidService.get(id);
        Ipvalid ipvalid = list.get(0);
        String ipinfo = IPUtils.getIpFromLong(ipvalid.getIpAddress());
        List<String> iplist = new ArrayList<>();
        iplist.add(String.valueOf(ipvalid.getId()));
        iplist.add(ipinfo);
        iplist.add(ipvalid.getStatus());
        iplist.add(String.valueOf(ipvalid.getCalendar()));
        return iplist;
    }

    @GetMapping("/getAll")
    public List<Ipvalid> getAll(){
        if(log.isTraceEnabled()){
            log.trace("getAll is called");
        }
        List<Ipvalid> list = iiPvalidService.getAll();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(long id){
        if(log.isTraceEnabled()){
            log.trace("delet is called"+id);
        }
        try{
            if(iiPvalidService.delete(id)){
                return "delete successfully";
            }else {
                return "delete error";
            }

        }catch(Exception e){
            return "delete abend"+e.toString();
        }
    }

    @RequestMapping("/update")
    public String update(long id,String ip,String status){
        if(log.isTraceEnabled()){
            log.trace("update is called"+id+ip+status);
        }
        IPUtils ipUtils=new IPUtils();
        if(!ipUtils.isIP(ip))
        {
            return "ip format not correct";
        }

        status=status.toUpperCase().trim();
        if (!STATUSLIST.contains(status)){
            return "status error,The status could be one of the following:\n" +
                    "STOPPED, BOOTING, STARTED.";
        }
        switch (status){
            case "BOOTING": status = "2";break;
            case "STOPPED": status = "1";break;
            case "STARTED": status = "3";break;
            default : status = "0"; break;
        }

        try{
            long tip = IPUtils.getIpFromString(ip);
            Ipvalid ipvalid = new Ipvalid(id,tip,status);
            if(iiPvalidService.update(ipvalid)){
                Thread.sleep(4000);
                return "update successfully";
            }
            else{
                return "update fail";
            }
        }
        catch(Exception e){
            return "update abend"+e.toString();
        }

    }
}

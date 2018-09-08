package com.wm.bcgame.controller;

import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.dao.SysParmDao;
import com.wm.bcgame.model.SysParm;
import com.wm.bcgame.service.SysParmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TestController {
    @Resource
    SysParmService sysParmService;
    @RequestMapping(value = "/get")
    public List<SysParm> getOne(){
        List<SysParm> sysParms = new ArrayList<SysParm>();
        QueryMap queryMap = new QueryMap();
        queryMap.put("parmValues","lzm");
        sysParms = sysParmService.search(queryMap);
        return sysParms;
    }
    @RequestMapping(value = "insert")
    public Long insert(){
        SysParm sysParm = new SysParm();
        sysParm.setparmCode(13L);
        sysParm.setparmValues("beauty");
        sysParm.setparmDescr("mary");
        return  sysParmService.create(sysParm);
    }

    @RequestMapping(value = "update")
    public Long update(){
        SysParm sysParm ;
        sysParm = sysParmService.get(16L);
        sysParm.setparmValues("lzmlzmlzm");
        sysParm.setDisabled(1L);
        return sysParmService.update(sysParm);
    }
}

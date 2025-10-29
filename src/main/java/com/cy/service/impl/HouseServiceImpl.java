package com.cy.service.impl;

import com.cy.mapper.HouseMapper;
import com.cy.model.House;
import com.cy.service.HouseService;
import com.cy.util.ResultData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
private HouseMapper houseMapper;
    @Override
    public ResultData findAll(HashMap<String, Object> map) {
        int pageNum = (int)map.get("pageNum");
        int pageSize = (int)map.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<House> house =houseMapper.findAll(map);
        PageInfo<House> info = new PageInfo<>(house);
        long count = info.getTotal();
        return ResultData.ok(house,count);
    }

    @Override
    public ResultData addOne(House house) {
        boolean isok=houseMapper.addOne(house);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData updateById(House house) {
        boolean isok = houseMapper.updateById(house);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData deleteById(int i) {
        boolean isok=houseMapper.deleteById(i);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData pldeleteByIds(Integer[] ids) {
        boolean isok=houseMapper.pldeleteByIds(ids);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }
}

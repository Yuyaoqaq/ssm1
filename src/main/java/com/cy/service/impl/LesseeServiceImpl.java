package com.cy.service.impl;

import com.cy.mapper.LesseeMapper;
import com.cy.model.Lessee;
import com.cy.service.LesseeService;
import com.cy.util.ResultData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class LesseeServiceImpl implements LesseeService {
    @Autowired
    private LesseeMapper lesseeMapper;
    @Override
    public ResultData findAll(HashMap<String, Object> map) {
        int pageNum = (int)map.get("pageNum");
        int pageSize = (int)map.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<Lessee> lessee =lesseeMapper.findAll(map);
        PageInfo<Lessee> info = new PageInfo<>(lessee);
        long count=info.getTotal();
        return ResultData.ok(lessee,count);
    }

    @Override
    public ResultData addOne(Lessee lessee) {
        boolean isok=lesseeMapper.addOne(lessee);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData updateById(Lessee lessee) {
        boolean isok = lesseeMapper.updateById(lessee);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData deleteById(int i) {
        boolean isok=lesseeMapper.deleteById(i);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData pldeleteByIds(Integer[] ids) {
        boolean isok=lesseeMapper.pldeleteByIds(ids);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }
}

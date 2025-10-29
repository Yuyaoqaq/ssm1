package com.cy.service.impl;

import com.cy.mapper.ContractMapper;
import com.cy.model.Contract;
import com.cy.model.VO.ContractVO;
import com.cy.service.ContractService;
import com.cy.util.ResultData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
private ContractMapper contractMapper;
    @Override
    public ResultData findAll(HashMap<String, Object> map) {
        int pageNum = (int)map.get("pageNum");
        int pageSize = (int)map.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<ContractVO> contractVO =contractMapper.findAll(map);
        long count = new PageInfo<>(contractVO).getTotal();
        return ResultData.ok(contractVO,count);
    }

    @Override
    public ResultData addOne(Contract contract) {
        boolean isok=contractMapper.addOne(contract);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData updateById(Contract contract) {
        boolean isok = contractMapper.updateById(contract);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData deleteById(int i) {
        boolean isok=contractMapper.deleteById(i);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }

    @Override
    public ResultData pldeleteByIds(Integer[] ids) {
        boolean isok=contractMapper.pldeleteByIds(ids);
        if(isok){
            return ResultData.ok();
        }else{
            return ResultData.fail();
        }
    }
}

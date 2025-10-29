package com.cy.web.controller.contract;

import com.cy.model.Contract;
import com.cy.service.ContractService;
import com.cy.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
@RequestMapping("/contract")
public class ConotractController {
    @Autowired
    private ContractService contractService;
    @RequestMapping("/list")
    public ResultData contractList(int page,int limit,String num){
        //accept
        //{addr: 'beijing', floor: '', area: '', deco: '0'}
        HashMap<String,Object> map=new HashMap<>();
        map.put("pageNum",page);
        map.put("pageSize",limit);
        map.put("num",num);
        //service
        ResultData resultData = contractService.findAll(map);
        //response
        return resultData;
    }
    @RequestMapping("/add")
    public ResultData contracAdd(Contract contract){
        //accept
        //service
        ResultData resultData =contractService.addOne(contract);
        //response
        return resultData;
    }
    @RequestMapping("/delete")
    public ResultData contracDelete(int id){
        //ac
        //ser
        ResultData resultData= contractService.deleteById(id);
        //resp
        return resultData;
    }
    @RequestMapping("/edit")
    public ResultData contracEdit(Contract contract){
        //ac
        //ser
        ResultData resultData=contractService.updateById(contract);
        //res
        return resultData;
    }
    @RequestMapping("/pldelete")
    public ResultData contracPldelete(Integer []ids){
        //ac
        //System.out.println(ids);
        //ser
        ResultData resultData=contractService.pldeleteByIds(ids);
        //resp
        return resultData;
    }

}

package com.cy.web.controller.lessee;

import com.cy.model.Lessee;
import com.cy.service.LesseeService;
import com.cy.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
@RequestMapping("/lessee")
public class LesseeController {
    @Autowired
    private LesseeService lesseeService;

    @RequestMapping("/list")
    public ResultData lesseeList(int page,int limit,String name,String idCard){
        //accept
        //{addr: 'beijing', floor: '', area: '', deco: '0'}
        HashMap<String,Object> map=new HashMap<>();
        map.put("pageNum",page);
        map.put("pageSize",limit);
        map.put("name",name);
        map.put("idCard",idCard);
        //service
        ResultData resultData = lesseeService.findAll(map);
        //response
        return resultData;
    }
    @RequestMapping("/add")
    public ResultData lesseeAdd(Lessee lessee){
        //accept
        //service
        ResultData resultData =lesseeService.addOne(lessee);
        //response
        return resultData;
    }
    @RequestMapping("/delete")
    public ResultData lesseeDelete(int id){
        //ac
        //ser
        ResultData resultData= lesseeService.deleteById(id);
        //resp
        return resultData;
    }
    @RequestMapping("/edit")
    public ResultData lesseeEdit(Lessee lessee){
        //ac
        //ser
        ResultData resultData=lesseeService.updateById(lessee);
        //res
        return resultData;
    }
    @RequestMapping("/pldelete")
    public ResultData lesseePldelete(Integer []ids){
        //ac
        //System.out.println(ids);
        //ser
        ResultData resultData=lesseeService.pldeleteByIds(ids);
        //resp
        return resultData;
    }
}

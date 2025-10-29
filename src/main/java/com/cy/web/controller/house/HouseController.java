package com.cy.web.controller.house;

import com.cy.model.House;
import com.cy.service.HouseService;
import com.cy.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/list")
    public ResultData houseList(int page,int limit,String addr,Integer floor,String area,Integer deco){
        //accept
       //{addr: 'beijing', floor: '', area: '', deco: '0'}
        HashMap<String,Object> map=new HashMap<>();
        map.put("pageNum",page);
        map.put("pageSize",limit);
        map.put("addr",addr);
        map.put("floor",floor);
        map.put("area",area);
        map.put("deco",deco);
        //service
        ResultData resultData = houseService.findAll(map);
        return resultData;
    }
    @RequestMapping("/add")
    public ResultData houseAdd(House house){
        if(house.getStatus()==0){
            // 方案2：如果不允许为0，返回错误提示
            ResultData resultData = ResultData.fail("请选择有效的状态");
            return resultData;
        }
        //service
        ResultData resultData =houseService.addOne(house);
        //response
        return resultData;
    }
    @RequestMapping("/delete")
    public ResultData houseDelete(int id){
        //ac
        //ser
        ResultData resultData= houseService.deleteById(id);
        //resp
        return resultData;
    }
    @RequestMapping("/edit")
    public ResultData houseEdit(House house){
        //ac
        if(house.getStatus()==0){
            // 方案2：如果不允许为0，返回错误提示
            ResultData resultData = ResultData.fail("请选择有效的状态");
            return resultData;
        }
        //ser
        ResultData resultData=houseService.updateById(house);
        //res
        return resultData;
    }
    @RequestMapping("/pldelete")
    public ResultData housePldelete(Integer[] ids){
        //ac
        //System.out.println(ids);
        //ser
        ResultData resultData=houseService.pldeleteByIds(ids);
        //resp
        return resultData;
    }
}

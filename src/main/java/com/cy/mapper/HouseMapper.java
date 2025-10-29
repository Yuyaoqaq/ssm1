package com.cy.mapper;

import com.cy.model.House;

import java.util.HashMap;
import java.util.List;

public interface HouseMapper {
    List<House> findAll(HashMap<String, Object> map);

    boolean addOne(House house);
    boolean updateById(House house);

    boolean deleteById(int i);

    boolean pldeleteByIds(Integer[] ids);
}

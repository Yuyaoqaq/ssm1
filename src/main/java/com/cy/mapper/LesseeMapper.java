package com.cy.mapper;

import com.cy.model.Lessee;

import java.util.HashMap;
import java.util.List;

public interface LesseeMapper {

    List<Lessee> findAll(HashMap<String, Object> map);

    boolean addOne(Lessee lessee);

    boolean updateById(Lessee lessee);

    boolean deleteById(int i);

    boolean pldeleteByIds(Integer[] ids);
}

package com.cy.mapper;

import com.cy.model.Contract;
import com.cy.model.VO.ContractVO;

import java.util.HashMap;
import java.util.List;

public interface ContractMapper {
    List<ContractVO> findAll(HashMap<String, Object> map);

    boolean addOne(Contract contract);

    boolean updateById(Contract contract);

    boolean deleteById(int i);

    boolean pldeleteByIds(Integer[] ids);
}

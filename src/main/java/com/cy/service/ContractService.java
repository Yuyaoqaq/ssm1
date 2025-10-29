package com.cy.service;

import com.cy.model.Contract;
import com.cy.util.ResultData;

import java.util.HashMap;

public interface ContractService {
    ResultData findAll(HashMap<String, Object> map);

    ResultData addOne(Contract contract);

    ResultData updateById(Contract contract);

    ResultData deleteById(int i);

    ResultData pldeleteByIds(Integer[] ids);
}

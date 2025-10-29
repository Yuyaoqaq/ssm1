package com.cy.model.VO;

import com.cy.model.Contract;
import com.cy.model.House;
import com.cy.model.Lessee;

public class ContractVO extends Contract {
    private House house;
    private Lessee lessee;

    @Override
    public String toString() {
        return "ContractVO{" +
                "house=" + house +
                ", leesee=" + lessee +
                '}';
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Lessee getLeesee() {
        return lessee;
    }

    public void setLeesee(Lessee leesee) {
        this.lessee = leesee;
    }
}

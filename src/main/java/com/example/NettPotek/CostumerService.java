package com.example.NettPotek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CostumerService {

    @Autowired
    CostumerRepository costumerRepository ;

    public Costumer createCostumer(Costumer costumer) {
            return costumerRepository.save(costumer);

    }
    public boolean deleteCostumer(Long id) {
        if(costumerRepository.findById(id)!=null){
            costumerRepository.deleteById(id);
            return true ;
        }
        return false ;
    }

    public Costumer findById(long id){
        return costumerRepository.findById(id).orElse(null) ;
    }

    public List<Costumer> findAll(){
        return (List<Costumer>) costumerRepository.findAll();
    }

    public Costumer updateCostumer(Costumer costumer){
        Costumer newCostumer = costumerRepository.findById(costumer.getId()).orElseThrow(() ->new NullPointerException());

        if(costumer.getName()!=null)
            newCostumer.setName(costumer.getName());
        if(costumer.getLastname()!=null)
            newCostumer.setLastname(costumer.getLastname());
        if(costumer.getTelephone()!=null)
            newCostumer.setTelephone(costumer.getTelephone());
        return costumerRepository.save(newCostumer) ;
    }

}

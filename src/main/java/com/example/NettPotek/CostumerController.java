package com.example.NettPotek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CostumerController {

    @Autowired
    CostumerService costumerService ;

    @PostMapping("/createCostumer")
    @ResponseBody
    public ResponseEntity createCostumer(@RequestBody Costumer costumer){

        return ResponseEntity.status(HttpStatus.CREATED).body(costumerService.createCostumer(costumer));
    }

    @GetMapping("/findAllCostumer")
    public List<Costumer> findAllCostumer(){
        return costumerService.findAll() ;
    }

   @GetMapping("/findById/{id}")
   public Costumer findById(@PathVariable long id){
        return costumerService.findById(id) ;
   }

   @PutMapping("/updateCostumer")
    public Costumer updateCostumer(@RequestBody Costumer costumer){
        return costumerService.updateCostumer(costumer);
   }
   @DeleteMapping("/deleteCostumer/{id}")
    public ResponseEntity<HttpStatus> deleteCostumer(@PathVariable long id){
        boolean deleted =costumerService.deleteCostumer(id) ;
        if(deleted)
            return new ResponseEntity<>(HttpStatus.OK) ;
        else
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
   }
}

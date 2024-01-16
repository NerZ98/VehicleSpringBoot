package com.mithil.car.controller;

import com.mithil.car.entities.car;
import com.mithil.car.repo.CarRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Table(name="car")
public class CarRepoController {

    @Autowired
    CarRepository repo;

    @RequestMapping(value="/cars", method= RequestMethod.POST)
    public car createcar(@RequestBody car cr){
        return repo.save(cr);
    }

    @RequestMapping(value="/car", method = RequestMethod.GET)
    public List<car> readcars(){
        return repo.findAll();
    }

    @RequestMapping(value="/car/{id}", method = RequestMethod.GET)
    public car readcars(@PathVariable("id")int id){
        return  repo.findById(id).get();
    }

    @RequestMapping(value = "/car/{id}", method=RequestMethod.PUT)
    public car updatecar(@PathVariable(value = "id")int id,
                         @RequestBody car cr){
        return  repo.save(cr);
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE)
    public void deletecar(@PathVariable("id") int id){
        repo.deleteById(id);
    }

}
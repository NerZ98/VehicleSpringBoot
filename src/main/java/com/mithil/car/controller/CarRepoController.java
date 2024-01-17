package com.mithil.car.controller;

import com.mithil.car.entities.car;
import com.mithil.car.repo.CarRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Table(name="car")
public class CarRepoController {

    @Autowired
    CarRepository repo;

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

//    @RequestMapping("/carform")
//    public ModelAndView carform(@ModelAttribute car cr) {
//        System.out.println("Controller method executed");
//        ModelAndView mav = new ModelAndView("carform");
//        mav.addObject("car", cr); // This ensures that the form data is bound to the existing instance
//        repo.save(cr);
//        return mav;
//    }

    @PostMapping("/carform")
    public ModelAndView carform(@ModelAttribute car cr) {
        System.out.println("Controller method executed");

        // Check if the form is submitted (POST request)
        // If not, you can add additional logic or redirect to the form page
        if (org.springframework.util.StringUtils.isEmpty(cr.getName())) {
            // Handle the case where the form is not submitted
            // You may want to add additional logic or redirect to the form page
            return new ModelAndView("carform");
        }

        ModelAndView mav = new ModelAndView("carform");
        mav.addObject("car", cr); // This ensures that the form data is bound to the existing instance
        repo.save(cr);
        return mav;
    }

    @RequestMapping(value = "/carlist", method = RequestMethod.GET)
    public ModelAndView carList() {
        ModelAndView mav = new ModelAndView("carlist");
        List<car> cars = repo.findAll();
        mav.addObject("cars", cars);
        return mav;
    }



    @GetMapping("/carSelector")
    public ModelAndView carSelector() {
        List<car> cars = repo.findAll();
        ModelAndView mav = new ModelAndView("carSelector");
        mav.addObject("cars", cars);
        mav.addObject("id", 1    ); // Set a default value or choose based on your requirements
        return mav;
    }

    @GetMapping("/updateCarForm/{id}")
    public ModelAndView updateCarForm(@PathVariable("id") int id) {
        car existingCar = repo.findById(id).orElse(new car());
        ModelAndView mav = new ModelAndView("updateCarForm");
        mav.addObject("car", existingCar);
        return mav;
    }

    @PostMapping("/updateCar/{id}")
    public ModelAndView updateCar(@PathVariable("id") int id, @ModelAttribute car updatedCar) {
        // Retrieve the existing car from the database
        car existingCar = repo.findById(id).orElse(new car());

        if (existingCar != null) {
            // Update the properties of the existing car with the new values
            existingCar.setName(updatedCar.getName());
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setDoor(updatedCar.getDoor());
            existingCar.setPowertrain(updatedCar.getPowertrain());
            existingCar.setType(updatedCar.getType());
            existingCar.setHp(updatedCar.getHp());
            existingCar.setMileage(updatedCar.getMileage());
            existingCar.setPrice(updatedCar.getPrice());

            // Save the updated car to the repository
            repo.save(existingCar);

            ModelAndView mav = new ModelAndView("redirect:/carSelector");
            return mav;
        } else {
            // Handle the case where the car with the given ID is not found
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("errorMessage", "Car not found with ID: " + id);
            return mav;
        }
    }

}
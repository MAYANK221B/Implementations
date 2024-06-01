package Hibernate.controller;

import Hibernate.entity.EquityDto;
import Hibernate.service.EquityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equity")
public class EquityController {

    private EquityService equityService;

    @Autowired
    EquityController(EquityService  equityService){
        this.equityService = equityService;
    }

    @GetMapping("/findByCategory")
    public ResponseEntity<String> getEquityByCategory(@RequestParam(required = false) String category){
        try{
            System.out.println("Finding equity using category");
            if(category==null) {
                System.out.println("Category is null");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
            }
            else {
                System.out.println("Category value is: " + category);
                return ResponseEntity.ok(equityService.getEquitiesByCategory(category).toString());
            }
        }
        catch (Exception e){
            System.out.println("Exception : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }


    }

    @PostMapping("/save")
    public ResponseEntity<String> saveEquity(@RequestBody(required = false) EquityDto equityDto){
        System.out.println("Saving Equity");
        try{
            if(equityDto==null){
                System.out.println("No equity info");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No equity info");
            }
            else {
                equityService.saveEquity(equityDto);
                System.out.println("Equity saved");
                return ResponseEntity.ok("Equity saved");
            }
        }
        catch (Exception e){
            System.out.println("Exception occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    @DeleteMapping("/deleteByName")
    public ResponseEntity<String> deleteByName(@RequestParam(required = false) String name) {
        System.out.println("Deleting Equity");

        try {
            if (name==null){
                System.out.println("No Name received");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No Name received");
            }
             else {
                 int numRows = equityService.deleteByName(name);
                 if (numRows == 0) {
                     String msg = "Equity : " + name + " not present";
                     System.out.println(msg);
                     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
                 }
                 else {
                     System.out.println("Number of rows affected: " + numRows);
                     return ResponseEntity.ok("Equity deleted");
                 }
            }
        }
        catch (Exception e){
            System.out.println("Exception occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}

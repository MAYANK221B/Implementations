package Hibernate.controller;

import Hibernate.entity.CustomerDto;
import Hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<String> saveCustomer(@RequestBody(required = false) CustomerDto customerDto) {
        try {
            System.out.println("Adding Customer: " + customerDto.toString());
            if (customerDto == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Received no customer");
            }
            boolean isSave = customerService.saveCustomer(customerDto);
            if (isSave) {
                return ResponseEntity.ok("Customer Added Successfully");
            } else
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed saving customer");
    }
        catch (IllegalArgumentException e){
            System.out.println("Illegal Argument");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Received no customer");
        }
        catch (Exception e){
            System.out.println("Exception : " + e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed saving customer");
        }
        }

        @GetMapping("/findByKey")
        public ResponseEntity<String> findCustomer(@RequestParam(required = false) Integer key){
        try{
            System.out.println("Finding Customer with Key " + key);
            if(key==null){
                System.out.println("Key is null");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Received no key");
            }
            String details = customerService.findCustomer(key);
            if(details==null){
                System.out.println("no Customer Found with key: " + key);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no Customer Found with key: " + key);
            }
            else{
                System.out.println("Customer Detail: " + details.toString());
                return ResponseEntity.ok(details.toString());}
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong");
        }
        }

}

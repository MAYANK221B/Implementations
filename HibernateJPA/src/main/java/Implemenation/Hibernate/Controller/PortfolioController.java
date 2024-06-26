package Implemenation.Hibernate.Controller;

import Implemenation.Hibernate.Entity.Portfolio;
import Implemenation.Hibernate.Service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/list")
    public List<Portfolio> getUsersList() {
        return portfolioService.list();
    }

    @GetMapping("/hello")
        public String hello(){
            return "Hello";
        }
    }



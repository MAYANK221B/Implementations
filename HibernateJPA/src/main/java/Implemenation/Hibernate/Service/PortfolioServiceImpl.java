package Implemenation.Hibernate.Service;

import Implemenation.Hibernate.Entity.Portfolio;
import Implemenation.Hibernate.Repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService{

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public List<Portfolio> list(){
        System.out.println(portfolioRepository.findById(1));
        return portfolioRepository.findAll();
    }

}

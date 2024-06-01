package Hibernate.service;

import Hibernate.dao.EquityDAO;
import Hibernate.entity.EquityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquityServiceImpl implements EquityService{
    private EquityDAO equityDAO;

    @Autowired
    EquityServiceImpl(EquityDAO equityDAO){
        this.equityDAO = equityDAO;
    }
    @Override
    public List<EquityDto> getEquitiesByCategory(String category) {
        return equityDAO.findByCategory(category);
    }

    @Override
    public void saveEquity(EquityDto equityDto) {
        equityDAO.saveEquity(equityDto);
    }

    @Override
    public int deleteByName(String name) {
        return equityDAO.deleteByName(name);
    }
}

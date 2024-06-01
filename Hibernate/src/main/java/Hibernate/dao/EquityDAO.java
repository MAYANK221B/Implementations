package Hibernate.dao;

import Hibernate.entity.EquityDto;

import java.util.List;

public interface EquityDAO {

    public List<EquityDto> findByCategory(String category);
    public void saveEquity(EquityDto equityDto);
    public EquityDto findById(int id);
    public int deleteByName(String name);

}

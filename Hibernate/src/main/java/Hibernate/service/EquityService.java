package Hibernate.service;

import Hibernate.entity.EquityDto;

import java.util.List;

public interface EquityService {
    public List<EquityDto> getEquitiesByCategory(String category);
    public void saveEquity(EquityDto equityDto);
    public int deleteByName(String name);

}

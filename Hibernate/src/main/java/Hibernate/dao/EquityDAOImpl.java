package Hibernate.dao;

import Hibernate.entity.EquityDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EquityDAOImpl implements EquityDAO  {

    private EntityManager entityManager;

    @Autowired
    EquityDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<EquityDto> findByCategory(String category) {
        TypedQuery<EquityDto> theQuery =  entityManager.createQuery("Select e from EquityDto e where e.category = :category", EquityDto.class);
        theQuery.setParameter("category", category);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void saveEquity(EquityDto equityDto) {
        entityManager.merge(equityDto);
    }

    @Override
    public EquityDto findById(int id) {
        return entityManager.find(EquityDto.class,1);
    }

    @Override
    @Transactional
    public int deleteByName(String name) {
        int numRows  = entityManager.createQuery("DELETE from EquityDto e where e.equityName = :name").setParameter("name",name).executeUpdate();
        return numRows;
    }
}

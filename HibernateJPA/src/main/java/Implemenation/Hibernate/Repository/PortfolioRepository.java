package Implemenation.Hibernate.Repository;

import Implemenation.Hibernate.Entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
}

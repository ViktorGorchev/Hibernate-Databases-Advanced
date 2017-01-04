package app.dao;

import app.domain.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TownDao extends JpaRepository<Town, Long>{
}

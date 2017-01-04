package app.dao;

import app.domain.Banks.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BankAccountDao extends JpaRepository<BankAccount, Long> {

}

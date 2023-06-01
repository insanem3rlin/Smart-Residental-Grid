package home.awattar_hourly_price.Repositories;

import home.awattar_hourly_price.Models.Datapoint;
import home.awattar_hourly_price.Models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}

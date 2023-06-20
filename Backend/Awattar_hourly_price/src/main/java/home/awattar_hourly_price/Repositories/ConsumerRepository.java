package home.awattar_hourly_price.Repositories;

import home.awattar_hourly_price.Models.Consumer;
import home.awattar_hourly_price.Models.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface ConsumerRepository extends CrudRepository<Consumer, Long> {
    Consumer findTopByOrderByIdDesc();
}

package home.awattar_hourly_price.Repositories;

import home.awattar_hourly_price.Models.PV;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PVRepository extends CrudRepository<PV, Long> {
}

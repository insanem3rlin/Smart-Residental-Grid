package home.awattar_hourly_price.Repositories;

import home.awattar_hourly_price.Models.Datapoint;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface DatapointRepository extends CrudRepository<Datapoint, Long> {

    List<Datapoint> findDatapointByStartDate(Timestamp time);

    Datapoint findTopByOrderByIdDesc();

    List<Datapoint> findDatapointByEndDateAfter(Timestamp timestamp);
}

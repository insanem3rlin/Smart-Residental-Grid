package home.awattar_hourly_price;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface DatapointRepository extends CrudRepository<Datapoint, Long> {

    List<Datapoint> findDatapointByStartDate(Timestamp time);

    /*@Query("SELECT AVG(value), CONCAT(CAST(MONTH(start_date) as char), ' ', CAST(YEAR(start_date) as char)) as  MonatJahr\n" +
            "FROM datapoint\n" +
            "GROUP BY MONTH(start_date), YEAR(start_date);")
    List<Datapoint> findDatapointsByStartDateYear();*/
}

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


    /**
     * TODO: des muss hald dann die beste value in die nächsten 24 hours zrückgeben und ned allgemein. K.A. wie des geht. Viel Spaß Flo!!!!
     * @return Datapoint
     */
    Datapoint findTopByOrderByValueAsc();
    /**
     * TODO: des muss hald dann die beste value in die nächsten 24 hours zrückgeben und ned allgemein. K.A. wie des geht. Viel Spaß Flo!!!!
     * @return Datapoint
     */
    Datapoint findTopByOrderByValueDesc();

    List<Datapoint> findDatapointByEndDateAfter(Timestamp timestamp);
}

package home.awattar_hourly_price.Logic;

import com.google.gson.Gson;
import home.awattar_hourly_price.Controller.DatapointController;
import home.awattar_hourly_price.Models.*;
import home.awattar_hourly_price.Repositories.BatteryRepository;
import home.awattar_hourly_price.Repositories.DatapointRepository;
import home.awattar_hourly_price.Repositories.PVRepository;
import home.awattar_hourly_price.Repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistence {

    private static Logger logger = Logger.getLogger(DatapointController.class.getName());

    public static Timestamp persistPV(double watt, Timestamp timestamp, PVRepository pvRepository) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        pvRepository.save(new PV(now, watt));
        return now;
    }

    public static Timestamp persistBattery(double chargingLevel, double value, Timestamp timestamp, BatteryRepository batteryRepository) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        double watt = (now.getTime() - timestamp.getTime()) * value / 1000;
        batteryRepository.save(new Battery(chargingLevel, watt, now));
        return now;
    }

    public static Timestamp persistSupplier(double value, Timestamp supplierTimestamp, SupplierRepository supplierRepository) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        double watt = (now.getTime() - supplierTimestamp.getTime()) * value / 1000;
        supplierRepository.save(new Supplier(watt, now));
        return now;
    }

    public static Timestamp persistDatapoints(DatapointRepository datapointRepository) {
        Gson gson = new Gson();
        String apiUrl;
        Datapoint lastRecord = datapointRepository.findTopByOrderByIdDesc();
        long end = System.currentTimeMillis();
        long start;
        if (lastRecord == null) {
            start = end - Long.parseLong("2592000000"); // minus 30 days in milliseconds
        } else {
            start = lastRecord.getEndDate().getTime();
        }
        end = end + 36 * 60 * 60 * 1000; // add 36 hours so get future market data
        apiUrl = "https://api.awattar.at/v1/marketdata?start=" + start + "&end=" + end;

        try {
            URL url = new URL(apiUrl);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            MarketData marketData = gson.fromJson(reader, MarketData.class);
            List<Datapoint> points = new ArrayList<>();
            for (Datapoint d : marketData.getData()) {
                d.setValue(d.getValue() / 10);
                d.setUnity("cent/kWH");
                points.add(d);
            }
            datapointRepository.saveAll(points);
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.toString());
        } finally {
            return new Timestamp(System.currentTimeMillis());
        }
    }

    public static List<Datapoint> getDatapoints(DatapointRepository datapointRepository, Timestamp timestamp) {
        return datapointRepository.findDatapointByEndDateAfter(timestamp);
    }
}

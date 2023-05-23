package home.awattar_hourly_price.Logic;

import home.awattar_hourly_price.Models.Battery;
import home.awattar_hourly_price.Models.PV;
import home.awattar_hourly_price.Models.Supplier;
import home.awattar_hourly_price.Repositories.BatteryRepository;
import home.awattar_hourly_price.Repositories.PVRepository;
import home.awattar_hourly_price.Repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;

@Controller
public class Persistance {

    @Autowired
    private static PVRepository pvRepository;
    @Autowired
    private static BatteryRepository batteryRepository;
    @Autowired
    private static SupplierRepository supplierRepository;

    public static Timestamp persistPV(double value, Timestamp timestamp){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        double watt = (now.getTime() - timestamp.getTime()) * value /1000;
        pvRepository.save(new PV(now, watt));
        return now;
    }

    public static Timestamp persistBattery(double chargingLevel, double value, Timestamp timestamp) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        double watt = (now.getTime() - timestamp.getTime()) * value /1000;
        batteryRepository.save(new Battery(chargingLevel, watt, now));
        return now;
    }

    public static Timestamp persistSupplier(double value, Timestamp supplierTimestamp) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        double watt = (now.getTime() - supplierTimestamp.getTime()) * value /1000;
        supplierRepository.save(new Supplier(watt, now));
        return now;
    }
}

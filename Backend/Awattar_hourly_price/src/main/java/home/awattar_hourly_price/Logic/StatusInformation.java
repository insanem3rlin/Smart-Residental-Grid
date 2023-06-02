package home.awattar_hourly_price.Logic;

import home.awattar_hourly_price.Models.Datapoint;
import home.awattar_hourly_price.Repositories.BatteryRepository;
import home.awattar_hourly_price.Repositories.DatapointRepository;
import home.awattar_hourly_price.Repositories.PVRepository;
import home.awattar_hourly_price.Repositories.SupplierRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static home.awattar_hourly_price.Logic.Persistence.*;

public class StatusInformation {

    private static int batteryCapacity;
    private static int batteryMaximum;
    private static int batteryMinimum;
    private static double batteryCharge;
    private static double pv;
    private static double supplier;
    private static double battery;
    private static Timestamp pvTimestamp;
    private static Timestamp batteryTimestamp;
    private static Timestamp supplierTimestamp;
    private static List<Datapoint> datapoints;

    public static void setProperties() {
        batteryMaximum = 100;
        batteryMinimum = 50;
        batteryCharge = 25;
        batteryCapacity = 200000;
        Timestamp now = new Timestamp(System.currentTimeMillis());
        pvTimestamp = now;
        batteryTimestamp = now;
        supplierTimestamp = now;
        datapoints = new ArrayList<>();
    }

    public static void setBatteryMaximum(int batteryMaximum) {
        StatusInformation.batteryMaximum = batteryMaximum;
    }

    public static void setBatteryMinimum(int batteryMinimum) {
        StatusInformation.batteryMinimum = batteryMinimum;
    }

    public static int getBatteryMaximum() {
        return batteryMaximum;
    }

    public static int getBatteryMinimum() {
        return batteryMinimum;
    }

    public static double getBatteryCharge() {
        return batteryCharge;
    }

    public static double getPv() {
        return pv;
    }

    public static void updatePV(double value, PVRepository pvRepository) {
        pvTimestamp = persistPV(pv, pvTimestamp, pvRepository);
        //if(value < dem)
        pv = value;
    }

    public static void updateBattery(double value, BatteryRepository batteryRepository) {
        batteryCharge = batteryCharge + (value / batteryCapacity);
        batteryTimestamp = persistBattery(batteryCharge, battery, batteryTimestamp, batteryRepository);
        battery = value;
    }

    public static void updateSupplier(double value, SupplierRepository supplierRepository) {
        supplierTimestamp = persistSupplier(supplier, supplierTimestamp, supplierRepository);
        supplier = value;
    }

    public static void updateDemand(double demand, SupplierRepository supplierRepository, BatteryRepository batteryRepository) {
        if (demand > pv) {
            updateBattery(-pv, batteryRepository);
            updateSupplier(pv - demand, supplierRepository);
        } else {
            updateBattery(-(pv - demand), batteryRepository);
        }
    }

    public static void updateDatapoints(DatapointRepository datapointRepository) {
        persistDatapoints(datapointRepository);
        datapoints.clear();
        datapoints.addAll(getDatapoints(datapointRepository, new Timestamp(System.currentTimeMillis())));
    }
}

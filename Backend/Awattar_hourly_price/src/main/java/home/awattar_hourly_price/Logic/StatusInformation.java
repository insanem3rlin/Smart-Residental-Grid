package home.awattar_hourly_price.Logic;

import java.sql.Timestamp;

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

    public static void setProperties() {
        batteryMaximum = 100;
        batteryMinimum = 50;
        batteryCharge = 0;
        batteryCapacity = 200000;
        Timestamp now = new Timestamp(System.currentTimeMillis());
        pvTimestamp = now;
        batteryTimestamp = now;
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

    public static double getPv() {return pv; }
    private static void updatePV(double value) {
        pvTimestamp = Persistance.persistPV(pv, pvTimestamp);
        pv = value;
    }

    private static void updateBattery(double value) {
        batteryCharge = batteryCharge + (value / batteryCapacity);
        batteryTimestamp = Persistance.persistBattery(batteryCharge, battery, batteryTimestamp);
        battery = value;
    }

    private static void updateSupplier(double value) {
        supplierTimestamp = Persistance.persistSupplier(supplier, supplierTimestamp);
        supplier = value;
    }
}

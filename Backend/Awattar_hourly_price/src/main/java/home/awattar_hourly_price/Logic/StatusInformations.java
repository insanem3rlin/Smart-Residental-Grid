package home.awattar_hourly_price.Logic;

public class StatusInformations {

    private static int batteryCapacity;

    private static int batteryMaximum;
    private static int batteryMinimum;

    private static double batteryCharge;

    public static void setProperties() {
        batteryMaximum = 100;
        batteryMinimum = 50;
        batteryCharge = 0;
        batteryCapacity = 200000;
    }

    public static void setBatteryMaximum(int batteryMaximum) {
        StatusInformations.batteryMaximum = batteryMaximum;
    }

    public static void setBatteryMinimum(int batteryMinimum) {
        StatusInformations.batteryMinimum = batteryMinimum;
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

    private static void calculateBatteryCharge(double change) {
        batteryCharge = batteryCharge + (change / batteryCapacity);
    }
}

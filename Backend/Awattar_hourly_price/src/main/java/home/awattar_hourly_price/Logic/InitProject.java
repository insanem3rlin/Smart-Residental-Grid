package home.awattar_hourly_price.Logic;

import home.awattar_hourly_price.Repositories.BatteryRepository;
import home.awattar_hourly_price.Repositories.DatapointRepository;
import home.awattar_hourly_price.Repositories.PVRepository;
import home.awattar_hourly_price.Repositories.SupplierRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static home.awattar_hourly_price.Logic.StatusInformation.*;

@Component
public class InitProject {

    private Timer pvTimer;
    private Timer demandTimer;
    private Timer marketDataTimer;
    @Autowired
    PVRepository pvRepository;
    @Autowired
    BatteryRepository batteryRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    DatapointRepository datapointRepository;

    @PostConstruct
    private void init() {
        setProperties();
        pvTimer = new Timer();
        demandTimer = new Timer();
        marketDataTimer = new Timer();

        //Start PV generation
        TimerTask pvTask = new TimerTask() {
            @Override
            public void run() {
                Random r = new Random();
                int i = r.nextInt(1200, 4500);
                try {
                    Thread.sleep(i);
                    updatePV(r.nextInt(i), pvRepository);
                    //System.out.println("PV new value");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        pvTimer.schedule(pvTask, 5000, 500);

        //Start demand generation
        TimerTask demandTask = new TimerTask() {
            @Override
            public void run() {
                Random r = new Random();
                int i = r.nextInt(1200, 4500);
                try {
                    Thread.sleep(i);
                    updateDemand(r.nextInt(i), supplierRepository, batteryRepository);
                    //System.out.println("Demand new value");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        demandTimer.schedule(demandTask, 5000, 500);

        //Start marketDtaTimer
        TimerTask marketTask = new TimerTask() {
            @Override
            public void run() {
                updateDatapoints(datapointRepository);
                System.out.println("Fetched new market data");
            }
        };
        long executionFrequency = 86400000; //24 * 60 * 60 * 1000 milliseconds equate to 1 day
        marketDataTimer.schedule(marketTask, 1500, executionFrequency);

    }

    @PreDestroy
    private void shutdown() {
        pvTimer.cancel();
        demandTimer.cancel();
        marketDataTimer.cancel();
        updatePV(0, pvRepository);
        updateBattery(0, batteryRepository);
        updateSupplier(0, supplierRepository);
    }
}

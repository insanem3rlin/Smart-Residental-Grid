import { Component } from '@angular/core';
import { interval } from 'rxjs';
import { EnergyConsumption } from 'src/app/EnergyConsumption';
import { EnergyService } from 'src/app/services/energy.service';

@Component({
  selector: 'app-energy-consumer',
  templateUrl: './energy-consumer.component.html',
  styleUrls: ['./energy-consumer.component.scss']
})
export class EnergyConsumerComponent {

  latestEnergyConsumption: EnergyConsumption;
  source = interval(1000);
  

  name: any;
  level: any;
  width: any;

  constructor(private energyService: EnergyService) { }

  ngOnInit(): void {
    this.getLatestEnergyConsumption();
    this.source.subscribe(value => {
      this.getLatestEnergyConsumption();
      this.width = this.latestEnergyConsumption.watt; //Anstatt "this.width müsste man denke ich dann ebenfalls this.getLatestBatteryLevel() nehmen. dann wär das vermutlich bereits der richtige Wert aus dem Backend"
      this.name = "Latest Energy Consumption in Watts";
      this.level= this.width;
    });
  }

  getLatestEnergyConsumption() {
    this.energyService.getLatestEnergyConsumption().subscribe(result => {
      this.latestEnergyConsumption = result;
    })
  }
  scaleProgressValue(value: number, minValue: number, maxValue: number): number {
    return ((value - minValue) / (maxValue - minValue)) * 100;
  }

  getColor(value: number): string {
    if (value < 1500) {
      return '#008000'; // green for values less than 1500
    } else if (value < 3000) {
      return '#ff8c00'; // orange for values between 1500 and 3000
    } else {
      return '#ff0000'; // red for values greater than 3000
    }
  }

}


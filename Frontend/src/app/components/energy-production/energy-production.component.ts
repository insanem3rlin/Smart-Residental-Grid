import { Component } from '@angular/core';
import { interval } from 'rxjs';
import { EnergyProduction } from 'src/app/EnergyProduction';
import { EnergyService } from 'src/app/services/energy.service';

@Component({
  selector: 'app-energy-production',
  templateUrl: './energy-production.component.html',
  styleUrls: ['./energy-production.component.scss']
})
export class EnergyProductionComponent {
  listOfEnergyProduction: EnergyProduction[];
  latestEnergyProduction: EnergyProduction;
  source = interval(1000);

  name: any;
  level: any;
  width: any;

  constructor(private energyService: EnergyService) { }

  ngOnInit(): void {
    this.getLatestEnergyProduction();
    this.source.subscribe(value => {
      this.getLatestEnergyProduction();
      this.width = this.latestEnergyProduction.watt; //Anstatt "this.width müsste man denke ich dann ebenfalls this.getLatestBatteryLevel() nehmen. dann wär das vermutlich bereits der richtige Wert aus dem Backend"
      this.name = "Latest Energy Production in Watts";
      this.level= this.width;
    });
  }

  getLatestEnergyProduction() {
    this.energyService.getLatestEnergyProduction().subscribe(result => {
      this.listOfEnergyProduction = result;
      this.latestEnergyProduction = this.listOfEnergyProduction[this.listOfEnergyProduction.length-1];
    })
  }
  scaleProgressValue(value: number, minValue: number, maxValue: number): number {
    return ((value - minValue) / (maxValue - minValue)) * 100;
  }

  getColor(value: number): string {
    if (value < 1500) {
      return '#ff0000'; // red for values less than 1500
    } else if (value < 3000) {
      return '#ff8c00'; // orange for values between 1500 and 3000
    } else {
      return '#008000'; // green for values greater than 3000
    }
  }

}


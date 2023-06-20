import { Component } from '@angular/core';
import { interval } from 'rxjs';
import { EnergySupply } from 'src/app/EnergySupply';
import { EnergyService } from 'src/app/services/energy.service';


@Component({
  selector: 'app-energy-supply',
  templateUrl: './energy-supply.component.html',
  styleUrls: ['./energy-supply.component.scss']
})
export class EnergySupplyComponent {

  latestEnergySupply: EnergySupply;
  source = interval(1000);

  name: any;
  level: any;
  width: any;

  constructor(private energyService: EnergyService) { }

  ngOnInit(): void {
    this.getLatestEnergySupply();
    this.source.subscribe(value => {
      this.getLatestEnergySupply();
      this.width = this.latestEnergySupply.watt; //Anstatt "this.width müsste man denke ich dann ebenfalls this.getLatestBatteryLevel() nehmen. dann wär das vermutlich bereits der richtige Wert aus dem Backend"
      this.name = "Latest Energy Supply in Watts";
      this.level= this.width;
    });
  }

  getLatestEnergySupply() {
    this.energyService.getLatestEnergySupply().subscribe(result => {
      this.latestEnergySupply = result;
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


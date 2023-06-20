import { Component } from '@angular/core';
import { interval } from 'rxjs';
import { EnergyConsumption } from 'src/app/EnergyConsumption';
import { EnergyService } from 'src/app/services/energy.service';

@Component({
  selector: 'app-energy-usage',
  templateUrl: './energy-usage.component.html',
  styleUrls: ['./energy-usage.component.scss']
})
export class EnergyUsageComponent {
  latestEnergyConsumption: EnergyConsumption;
  source = interval(1000);

  name: any;
  level: any;
  width: any;

  constructor(private energyService: EnergyService) { }

  ngOnInit(): void {
    this.getLatestEnergyProduction();
    this.source.subscribe(value => {
      this.getLatestEnergyProduction();
      this.width = this.latestEnergyConsumption.watt; 
      this.name = "Latest Energy Consumption in Watts";
      this.level = this.width * -1;
    });
  }

  getLatestEnergyProduction() {
    this.energyService.getLatestEnergyConsumption().subscribe(result => {
      this.latestEnergyConsumption = result;
    })
  }

  roundValue(value: number) {
    return Math.round(value * 100) / 100;
  }

  scaleProgressValue(value: number, minValue: number, maxValue: number): number {
    return ((value - minValue) / (maxValue - minValue)) * 100;
  }
  getColor(value: number): string {
    if (value < 1500) {
      return '#008000'; 
    } else if (value < 3000) {
      return '#ff8c00'; 
    } else {
      return '#ff0000'; 
    }
  }
}


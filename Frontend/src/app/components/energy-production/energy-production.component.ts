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
}


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


  constructor(private energyService: EnergyService) { }

  ngOnInit(): void {
    this.getLatestEnergyProduction();
    this.source.subscribe(value => {
      this.getLatestEnergyProduction();
    });
  }

  getLatestEnergyProduction() {
    this.energyService.getLatestEnergyProduction().subscribe(result => {
      this.listOfEnergyProduction = result;
      this.latestEnergyProduction = this.listOfEnergyProduction[this.listOfEnergyProduction.length-1];
    })
  }
}


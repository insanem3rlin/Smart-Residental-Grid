import { Component } from '@angular/core';
import { interval } from 'rxjs';
import { Datapoint } from 'src/app/Datapoint';
import { DatapointService } from 'src/app/services/datapoint.service';

@Component({
  selector: 'app-energy-price',
  templateUrl: './energy-price.component.html',
  styleUrls: ['./energy-price.component.scss']
})
export class EnergyPriceComponent {
  latestEnergyPrice: Datapoint;
  source = interval(1000);

  width: any;
  name: any;
  level: any;

  constructor(private datapointService: DatapointService) { }

  ngOnInit(): void {
    this.getLatestDatapoint();
    this.source.subscribe(value => {
      this.getLatestDatapoint();
      this.width = this.latestEnergyPrice.value; //Anstatt "this.width müsste man denke ich dann ebenfalls this.getLatestBatteryLevel() nehmen. dann wär das vermutlich bereits der richtige Wert aus dem Backend"
      this.name = "Latest Energy Price in " + this.latestEnergyPrice.unity;
      this.level = this.width;
    });
  }

  getLatestDatapoint() {
    this.datapointService.getLatestDatapoint().subscribe(result => {
      this.latestEnergyPrice = result;
    })
  }
}

import { Component } from '@angular/core';
import { Datapoint } from 'src/app/Datapoint';
import { DatapointService } from 'src/app/services/datapoint.service';
import { EnergyService } from 'src/app/services/energy.service';

@Component({
  selector: 'app-decide-to-buy',
  templateUrl: './decide-to-buy.component.html',
  styleUrls: ['./decide-to-buy.component.scss']
})
export class DecideToBuyComponent {

  datapoint : Datapoint; 
  fillLevel: number;
  isBuy: boolean = true;
  constructor(private datapointService: DatapointService) {}
  ngOnInit(): void {
    this.datapointService.getBestSlotToBuy().subscribe(result => {
      this.datapoint = result;
    })
  }

  onSubmit() {
    this.datapointService.setTransaction(this.fillLevel, this.datapoint.startDate, this.datapoint.endDate, this.isBuy).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
  }
}



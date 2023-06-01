import { Component } from '@angular/core';
import { Datapoint } from 'src/app/Datapoint';
import { DatapointService } from 'src/app/services/datapoint.service';

@Component({
  selector: 'app-decide-to-sell',
  templateUrl: './decide-to-sell.component.html',
  styleUrls: ['./decide-to-sell.component.scss']
})
export class DecideToSellComponent {

  datapoint : Datapoint; 
  fillLevel: number;
  isBuy: boolean = false;
  constructor(private datapointService: DatapointService) {}
  ngOnInit(): void {
    this.datapointService.getBestSlotToSell().subscribe(result => {
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

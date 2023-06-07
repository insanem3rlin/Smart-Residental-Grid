import { Component } from '@angular/core';
import { interval } from 'rxjs';
import { Datapoint } from 'src/app/Datapoint';
import { DatapointService } from 'src/app/services/datapoint.service';
import { __values } from 'tslib';

@Component({
  selector: 'app-datapoint-table',
  templateUrl: './datapoint-table.component.html',
  styleUrls: ['./datapoint-table.component.scss']
})
export class DatapointTableComponent {
  tableData: Datapoint[];

  constructor(private datapointService: DatapointService) {}
  fill: number;
  fillTo: number;
  buy: boolean;
  selectedItem: any;
  //source = interval(1000);

  ngOnInit() {
    this.getData();
   
  }
  getData() {
    this.datapointService.getFutureDatapoints().subscribe(
      (data: any[]) => {
        this.tableData = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }



  submitData() {
    if (!this.selectedItem) {
      console.log('Please select an item before submitting.');
      return;
    }
    const selectedItems: Datapoint[] = this.tableData.filter((datapoint) => datapoint.selected);
    let dp: Datapoint = selectedItems.at(selectedItems.length-1);

    // Send the selectedColumnData to the backend
    this.datapointService.setTransaction(this.fillTo, this.fill, dp.startDate, dp.endDate, this.buy).subscribe(
      (response) => {
        console.log('Data submitted successfully:', response);
        // Reset the input and selection after successful submission
        this.fillTo = null;
        this.fill = null;
        this.buy = null;
        this.tableData.forEach((item) => {
          item.selected = false;
        });
      },
      (error) => {
        console.error('Error submitting data:', error);
      }
    );
  }

  roundValue(number: number) {
    const decimalPlaces: number = 2;
    const multiplier = Math.pow(10, decimalPlaces);
    return Math.round(number * multiplier) / multiplier;
  }

}

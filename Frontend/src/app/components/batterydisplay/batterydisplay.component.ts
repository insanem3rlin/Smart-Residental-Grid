import { Component, OnInit } from '@angular/core';
import { Observable, interval, tap } from 'rxjs';
import { BatteryLevel } from 'src/app/BatteryLevel';
import { BatteryService } from 'src/app/services/battery.service';


@Component({
  selector: 'app-batterydisplay',
  templateUrl: './batterydisplay.component.html',
  styleUrls: ['./batterydisplay.component.scss']
})
export class BatterydisplayComponent implements OnInit {

  latestBatteryLevel: BatteryLevel;
  source = interval(1000);
  width: number;
  name: any;
  level: any;


  constructor(private batteryService: BatteryService) { }

  ngOnInit(): void {
    this.getLatestBatteryLevel();
    this.source.subscribe(value => {
      this.getLatestBatteryLevel();
      this.width = this.latestBatteryLevel.chargingLevel;
      this.name = "Battery charging level";
      this.level= this.width + "%";
    });
  }

  getLatestBatteryLevel() {
    this.batteryService.getLatestBatteryLevel().subscribe(result => {
      this.latestBatteryLevel = result;
    })
  }


  roundValue(value: number) {
    return Math.round(value * 100) / 100;
  }

  getColor(value: number): string {
    if (value < 10) {
      return '#ff0000'; // red for values less than 1500
    } else if (value < 40) {
      return '#ff8c00'; // orange for values between 1500 and 3000
    } else {
      return '#008000'; // green for values greater than 3000
    }
  }
}

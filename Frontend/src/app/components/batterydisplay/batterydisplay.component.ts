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


  constructor(private batteryService: BatteryService) { }

  ngOnInit(): void {
    this.getLatestBatteryLevel();
    this.source.subscribe(value => {
      this.getLatestBatteryLevel();
    });
  }

  getLatestBatteryLevel() {
    this.batteryService.getLatestBatteryLevel().subscribe(result => {
      this.latestBatteryLevel = result;
    })
  }
}

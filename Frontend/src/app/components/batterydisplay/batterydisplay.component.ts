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
  width: any;
  name: any;
  level: any;


  constructor(private batteryService: BatteryService) { }

  ngOnInit(): void {
    this.getLatestBatteryLevel();
    this.source.subscribe(value => {
      this.getLatestBatteryLevel();
      this.width = this.latestBatteryLevel.chargingLevel; //Anstatt "this.width müsste man denke ich dann ebenfalls this.getLatestBatteryLevel() nehmen. dann wär das vermutlich bereits der richtige Wert aus dem Backend"
      this.name = "Battery charging level";
      this.level= this.width + "%";
    });
  }

  getLatestBatteryLevel() {
    this.batteryService.getLatestBatteryLevel().subscribe(result => {
      this.latestBatteryLevel = result;
    })
  }
}

import { Component, OnInit } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { BatteryLevel } from 'src/app/BatteryLevel';
import { BatteryService } from 'src/app/services/battery.service';


@Component({
  selector: 'app-batterydisplay',
  templateUrl: './batterydisplay.component.html',
  styleUrls: ['./batterydisplay.component.scss']
})
export class BatterydisplayComponent implements OnInit {

  latestBatteryLevel$: Observable<BatteryLevel>;

  constructor(private batteryService: BatteryService) { }

  ngOnInit(): void {
    this.latestBatteryLevel$ = this.batteryService.getLatestBatteryLevel();
  }
}

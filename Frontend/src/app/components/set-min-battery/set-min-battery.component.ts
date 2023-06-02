import { Component } from '@angular/core';
import { EnergyService } from 'src/app/services/energy.service';

@Component({
  selector: 'app-set-min-battery',
  templateUrl: './set-min-battery.component.html',
  styleUrls: ['./set-min-battery.component.scss']
})
export class SetMinBatteryComponent {
  public minLevel: number;
  public maxLevel: number;
  constructor(private energyService: EnergyService) {}

  onSubmit() {
    this.energyService.setMinBattery(this.minLevel, this.maxLevel).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
  }
  showPopup: boolean = false;

  openPopup() {
    this.showPopup = true;
    setTimeout(() => {
      this.showPopup = false;
    }, 1000); // Hide the popup after 3 seconds (adjust as needed)
  }
}

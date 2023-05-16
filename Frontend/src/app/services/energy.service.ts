import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { BatteryLevel } from '../BatteryLevel';
import { EnergyProduction } from '../EnergyProduction';

@Injectable({
  providedIn: 'root'
})
export class EnergyService {
  private energylevelAPI: string = 'http://localhost:8080/energylevel';
  private energyProductionAPI: string = 'http://localhost:8080/PV';

  constructor(private http: HttpClient) { }

  getLatestEnergyPrice(): Observable<BatteryLevel>{
    return this.http.get<BatteryLevel>(this.energylevelAPI);
  }

  getLatestEnergyProduction(): Observable<EnergyProduction[]> { 
    return this.http.get<EnergyProduction[]>(this.energyProductionAPI);
  }
}

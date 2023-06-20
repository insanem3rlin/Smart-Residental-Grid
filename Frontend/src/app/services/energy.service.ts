import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { BatteryLevel } from '../BatteryLevel';
import { EnergyProduction } from '../EnergyProduction';
import { EnergyConsumption } from '../EnergyConsumption';
import { Datapoint } from '../Datapoint';
import { Data } from '@angular/router';
import { EnergySupply } from '../EnergySupply';


@Injectable({
  providedIn: 'root'
})
export class EnergyService {
  private energylevelAPI: string = 'http://localhost:8080/energylevel';
  private energyProductionAPI: string = 'http://localhost:8080/PV';
  private energySupplierAPI: string = 'http://localhost:8080/supplier'
  private energyConsumerAPI: string = 'http://localhost:8080/consumer'
  private minBatteryApi: string = 'http://localhost:8080/setBatteryProperties'

  constructor(private http: HttpClient) { }

  getLatestEnergyPrice(): Observable<BatteryLevel>{
    return this.http.get<BatteryLevel>(this.energylevelAPI);
  }

  getLatestEnergyProduction(): Observable<EnergyProduction[]> { 
    return this.http.get<EnergyProduction[]>(this.energyProductionAPI);
  }
  getLatestEnergySupply(): Observable<EnergySupply> {
    return this.http.get<EnergySupply>(this.energySupplierAPI);
  }
  getLatestEnergyConsumption(): Observable<EnergyConsumption> {
    return this.http.get<EnergyConsumption>(this.energyConsumerAPI);
  }



  setMinBattery(min: number, max: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('minimum', min.toString());
    params = params.append('maximum', max.toString());

    return this.http.post(this.minBatteryApi, {}, { params:params });
  }


}

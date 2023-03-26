import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { BatteryLevel } from '../BatteryLevel';

@Injectable({
  providedIn: 'root'
})
export class BatteryService {
  private apiUrl: string = 'http://localhost:8080/battery';

  constructor(private http: HttpClient) { }

  getLatestBatteryLevel(): Observable<BatteryLevel>{
    return this.http.get<BatteryLevel>(this.apiUrl);
  } 

}

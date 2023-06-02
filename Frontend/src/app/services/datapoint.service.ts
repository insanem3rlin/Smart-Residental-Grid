import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Datapoint } from '../Datapoint';
import { Observable } from 'rxjs';
import { Data } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class DatapointService {
  private futureDatapointsAPI: string = "http://localhost:8080/futureDatapoints"
  private latestDatapointAPI: string = "http://localhost:8080/latestDatapoint"
  private bestSlotToBuyAPI: string = "http://localhost:8080/bestSlotToBuy"
  private bestSlotToSellAPI: string = "http://localhost:8080/bestSlotToSell"
  private transactionAPI: string ="http://localhost:8080/transaction"

  constructor(private http: HttpClient) { }


  getFutureDatapoints(): Observable<Datapoint[]> {
    return this.http.get<Datapoint[]>(this.futureDatapointsAPI);
  }

  getLatestDatapoint(): Observable<Datapoint> {
    return this.http.get<Datapoint>(this.latestDatapointAPI);
  }
  getBestSlotToBuy(): Observable<Datapoint> {
    return this.http.get<Datapoint>(this.bestSlotToBuyAPI)
  }

  getBestSlotToSell(): Observable<Datapoint> {
    return this.http.get<Datapoint>(this.bestSlotToSellAPI)
  }
  setTransaction(maxLevel:number, amount:number, startTime:Date, endTime:Date, isBuy:Boolean): Observable<any> {
    let params = new HttpParams();
    params = params.append('maxLevel', maxLevel.toString());
    params = params.append('amount', amount.toString());
    params = params.append('startTime', startTime.toString());
    params = params.append('endTime', endTime.toString());
    params = params.append('isBuy', isBuy.toString());
  
    return this.http.post(this.transactionAPI, {}, { params:params });
  }
}
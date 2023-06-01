import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Datapoint } from '../Datapoint';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatapointService {
  private latestDatapointAPI: string = "http://localhost:8080/latestDatapoint"
  constructor(private http: HttpClient) { }


  getLatestDatapoint(): Observable<Datapoint> {
    return this.http.get<Datapoint>(this.latestDatapointAPI);
  }

}

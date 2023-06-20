import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { PowerdisplayComponent } from './components/powerdisplay/powerdisplay.component';
import { BatterydisplayComponent } from './components/batterydisplay/batterydisplay.component';
import { EnergyPriceComponent } from './components/energy-price/energy-price.component';
import { EnergyProductionComponent } from './components/energy-production/energy-production.component';
import { EnergyFlowComponent } from './components/energy-flow/energy-flow.component';
import { SetMinBatteryComponent } from './components/set-min-battery/set-min-battery.component';
import { DecideToBuyComponent } from './components/decide-to-buy/decide-to-buy.component';
import { DecideToSellComponent } from './components/decide-to-sell/decide-to-sell.component';
import { PopupComponent } from './components/popup/popup.component';
import { DatapointTableComponent } from './components/datapoint-table/datapoint-table.component';
import { EnergySupplyComponent } from './components/energy-supply/energy-supply.component';
import { EnergyConsumerComponent } from './components/energy-consumer/energy-consumer.component';

const appRoutes: Routes = [
  
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    PowerdisplayComponent,
    BatterydisplayComponent,
    EnergyPriceComponent,
    EnergyProductionComponent,
    EnergyFlowComponent,
    SetMinBatteryComponent,
    DecideToBuyComponent,
    DecideToSellComponent,
    PopupComponent,
    DatapointTableComponent,
    EnergySupplyComponent,
    EnergyConsumerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes, {enableTracing: true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

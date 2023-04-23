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
import { EnergyUsageComponent } from './components/energy-usage/energy-usage.component';
import { EnergyFlowComponent } from './components/energy-flow/energy-flow.component';

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
    EnergyUsageComponent,
    EnergyFlowComponent
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

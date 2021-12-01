import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PraticienComponent } from './praticien/praticien.component';
import { PatientPriseRdvComponent } from './patient-prise-rdv/patient-prise-rdv.component';

@NgModule({
  declarations: [
    AppComponent,
    PraticienComponent
    PatientPriseRdvComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

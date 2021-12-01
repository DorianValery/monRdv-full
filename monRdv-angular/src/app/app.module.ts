import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LieuHttpService } from './lieu-http.service';
import { PraticienHttpService } from './praticien/praticien-http.service';
import { PraticienComponent } from './praticien/praticien.component';
import { PraticienLieuxComponent } from './praticien-lieux/praticien-lieux.component';



@NgModule({
  declarations: [
    AppComponent,
    PraticienComponent,
    PraticienLieuxComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule

  ],
  providers: [PraticienHttpService, LieuHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }

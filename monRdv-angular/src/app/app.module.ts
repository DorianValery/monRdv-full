import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PraticienHttpService } from './praticien/praticien-http.service';
import { PraticienComponent } from './praticien/praticien.component';



@NgModule({
  declarations: [
    AppComponent,
    PraticienComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule

  ],
  providers: [PraticienHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }

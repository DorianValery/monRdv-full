import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './../app-config.service';
import { Praticien } from '../model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PraticienHttpService {

  praticiens: Array<Praticien> = new Array<Praticien>();
  praticienUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.praticienUrl = this.appConfig.backEndUrl + "formateur/"
    this.load();
  }

  findAll(): Array<Praticien> {
    return this.praticiens;
  }

  findById(id: number): Observable<Praticien> {
    return this.http.get<Praticien>(this.praticienUrl + id);
  }

  create(praticien: Praticien) {
    this.http.post<Praticien>(this.praticienUrl, praticien).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(praticien: Praticien) {
    this.http.put<Praticien>(this.praticienUrl + praticien.id, praticien).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.praticienUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }
  load() {
    this.http.get<Array<Praticien>>(this.praticienUrl).subscribe(response => {
      this.praticiens = response;
    }, error => console.log(error));
  }
}

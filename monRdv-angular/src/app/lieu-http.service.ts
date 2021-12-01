import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';
import { Lieu } from './model';

@Injectable({
  providedIn: 'root'
})
export class LieuHttpService {
  lieux: Array<Lieu> = new Array<Lieu>();
  lieuUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.lieuUrl = this.appConfig.backEndUrl + "Lieu/"
    this.load();
  }

  findAll(): Array<Lieu> {
    return this.lieux;
  }

  like(filtre: string) {
    if (filtre) {
      this.http.get<Array<Lieu>>(this.lieuUrl + "Like/" + filtre).subscribe(response => {
        this.lieux = response;
      }, error => console.log(error));
    } else {
      this.load();
    }
  }

  findById(id: number): Observable<Lieu> {
    return this.http.get<Lieu>(this.lieuUrl + id);
  }

  create(lieu: Lieu) {
    this.http.post<Lieu>(this.lieuUrl, lieu).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(lieu: Lieu) {
    this.http.put<Lieu>(this.lieuUrl + lieu.id, lieu).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.lieuUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }
  load() {
    this.http.get<Array<Lieu>>(this.lieuUrl).subscribe(response => {
      this.lieux = response;
    }, error => console.log(error));
  }
}


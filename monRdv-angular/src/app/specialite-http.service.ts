import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';
import { Specialite } from './model';

@Injectable({
  providedIn: 'root'
})
export class SpecialiteHttpService {
  specialites: Array<Specialite> = new Array<Specialite>();
  SpecialiteUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.SpecialiteUrl = this.appConfig.backEndUrl + "Specialite/"
    this.load();
  }

  findAll(): Array<Specialite> {
    return this.specialites;
  }

  like(filtre: string) {
    if (filtre) {
      this.http.get<Array<Specialite>>(this.SpecialiteUrl + "Like/" + filtre).subscribe(response => {
        this.specialites = response;
      }, error => console.log(error));
    } else {
      this.load();
    }
  }

  findById(id: number): Observable<Specialite> {
    return this.http.get<Specialite>(this.SpecialiteUrl + id);
  }

  create(lieu: Specialite) {
    this.http.post<Specialite>(this.SpecialiteUrl, lieu).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(lieu: Specialite) {
    this.http.put<Specialite>(this.SpecialiteUrl + lieu.id, lieu).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.SpecialiteUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }
  load() {
    this.http.get<Array<Specialite>>(this.SpecialiteUrl).subscribe(response => {
      this.specialites = response;
    }, error => console.log(error));
  }
}


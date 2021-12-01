import { Injectable } from '@angular/core';
import { Creneau, Lieu, Motif, Praticien, Specialite } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PatientPriseRdvHttpService {

  rdvUrl: string;
  idpraticien: number;

  constructor(private appConfig: AppConfigService) {
    this.rdvUrl = this.appConfig.backEndUrl + "praticien/"+this.idpraticien;
    this.load(this.idpraticien);
  }

  load(id: number) {
    this.http.get<Praticien>(this.rdvUrl+id).subscribe(response => {
      this.praticien = response;
    }, error => console.log(error));
  }

  findSpec(id: number): Array<Specialite>{
    return this.http.get<Praticien>(this.rdvUrl+"Spe/"+ id).specialites;
  }

  findLieu(id: number): Array<Lieu>{
    return this.http.get<Praticien>(this.rdvUrl+"Lieux/"+ id).lieux;
  }

  findCren(id: number): Array<Creneau>{
    return this.http.get<Praticien>(this.rdvUrl+"Lieux/"+ id).creneaux;
  }
  findMotif(idSpec: number): Array<Motif>{
    return this.http.get<Praticien>(this.rdvUrl+"Lieux/"+ idSpec).motifs;
  }
}

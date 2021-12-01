import { Component, OnInit } from '@angular/core';
import { Praticien } from '../model';
import { PraticienLieuHttpService } from './praticien-lieu-http.service';

@Component({
  selector: 'app-praticien-lieux',
  templateUrl: './praticien-lieux.component.html',
  styleUrls: ['./praticien-lieux.component.scss']
})
export class PraticienLieuxComponent implements OnInit {

  praticienForm: Praticien;
 filtre: string;
 praticiens:Array<Praticien>;

  constructor(private praticienLieuService: PraticienLieuHttpService) {
   }

  ngOnInit(): void {
  }

  list(): Array<Praticien> {
    return this.praticienLieuService.findAll();
  }

  add() {
    this.praticienForm = new Praticien();
  }

  edit(id: number) {
    this.praticienLieuService.findById(id).subscribe(response => {
      this.praticienForm = response;
    }, err => console.log(err));
  }

  save() {
    if(this.praticienForm.id) {
      this.praticienLieuService.modify(this.praticienForm);
    } else {
      this.praticienLieuService.create(this.praticienForm);
    }

    this.cancel();
  }

  cancel() {
    this.praticienForm = null;
  }

  remove(id: number) {
    this.praticienLieuService.deleteById(id);
  }

  like($event: any) {
    this.filtre = $event;
    this.praticienLieuService.like(this.filtre);
  }

}




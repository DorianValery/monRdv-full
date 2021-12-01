import { Component, OnInit } from '@angular/core';
import { LieuHttpService } from '../lieu-http.service';
import { Lieu, Praticien } from '../model';
import { PraticienHttpService } from './praticien-http.service';

@Component({
  selector: 'app-praticien',
  templateUrl: './praticien.component.html',
  styleUrls: ['./praticien.component.scss']
})
export class PraticienComponent implements OnInit {

 praticienForm: Praticien;
 filtre: string;
 praticiens:Array<Praticien>;

  constructor(private praticienService: PraticienHttpService, private lieuService: LieuHttpService) {
    // this.loadLieux();
   }

  ngOnInit(): void {
  }

  list(): Array<Praticien> {
    return this.praticienService.findAll();
  }

  // loadLieux(id: number) {
  //   this.praticienService.findByIdWithLieux(id).subscribe(response => {
  //    this.praticienForm = response;
  //   }, error => console.log(error));
  // }

  add() {
    this.praticienForm = new Praticien();
  }

  edit(id: number) {
    this.praticienService.findById(id).subscribe(response => {
      this.praticienForm = response;
    }, err => console.log(err));
  }

  save() {
    if(this.praticienForm.id) {
      this.praticienService.modify(this.praticienForm);
    } else {
      this.praticienService.create(this.praticienForm);
    }

    this.cancel();
  }

  cancel() {
    this.praticienForm = null;
  }

  remove(id: number) {
    this.praticienService.deleteById(id);
  }

  like($event: any) {
    this.filtre = $event;
    this.praticienService.like(this.filtre);
  }

}

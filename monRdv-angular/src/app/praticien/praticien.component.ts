import { Component, OnInit } from '@angular/core';
import { Praticien } from '../model';
import { PraticienHttpService } from './praticien-http.service';

@Component({
  selector: 'app-praticien',
  templateUrl: './praticien.component.html',
  styleUrls: ['./praticien.component.scss']
})
export class PraticienComponent implements OnInit {

 praticienForm: Praticien;

  constructor(private praticienService: PraticienHttpService) { }

  ngOnInit(): void {
  }

  list(): Array<Praticien> {
    return this.praticienService.findAll();
  }

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


}

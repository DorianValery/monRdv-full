// import { Component, OnInit } from '@angular/core';

// @Component({
//   selector: 'app-praticien',
//   templateUrl: './praticien.component.html',
//   styleUrls: ['./praticien.component.scss']
// })
// export class PraticienComponent implements OnInit {

//  praticienForm: Praticien;

//   constructor(private praticienService: PraticienHttpService) { }

//   ngOnInit(): void {
//   }

//   list(): Array<Evaluation> {
//     return this.evaluationService.findAll();
//   }

//   add() {
//     this.evaluationForm = new Evaluation();
//   }

//   edit(id: number) {
//     this.evaluationService.findById(id).subscribe(response => {
//       this.evaluationForm = response;
//     }, err => console.log(err));
//   }

//   save() {
//     if(this.evaluationForm.id) {
//       this.evaluationService.modify(this.evaluationForm);
//     } else {
//       this.evaluationService.create(this.evaluationForm);
//     }

//     this.cancel();
//   }

//   cancel() {
//     this.evaluationForm = null;
//   }

//   remove(id: number) {
//     this.evaluationService.deleteById(id);
//   }
// }

// }

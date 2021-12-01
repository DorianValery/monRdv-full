import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { PraticienLieuxComponent } from './praticien-lieux/praticien-lieux.component';
import { PraticienComponent } from './praticien/praticien.component';

const routes: Routes = [
  { path: "praticien", component: PraticienComponent },
  // { path: "praticienLieu", component: PraticienLieuxComponent },
  { path: "lieu", component: PraticienComponent },
  { path: "", component: PraticienComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

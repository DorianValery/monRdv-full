import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PraticienComponent } from './praticien/praticien.component';

const routes: Routes = [
  { path: "praticien", component: PraticienComponent },
  { path: "", component: PraticienComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

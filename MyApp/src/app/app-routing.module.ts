import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import { ModifyemployeeComponent } from './modifyemployee/modifyemployee.component'

const routes: Routes = [
  {path:"delete",component:DeleteemployeeComponent},
  {path:"add", component:AddemployeeComponent},
  {path:"modify",component:ModifyemployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


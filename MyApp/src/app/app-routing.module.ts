import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import { ModifyemployeeComponent } from './modifyemployee/modifyemployee.component'
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';
import { EmployeetrainingComponent } from './employeetraining/employeetraining.component';

const routes: Routes = [
  {path :'',redirectTo:"/details",pathMatch:"full"},
  {path:"details",component:EmployeedetailsComponent,
  children: [
    { path: "add", component: AddemployeeComponent},
    { path: "modify", component: ModifyemployeeComponent},
    { path: "delete", component: DeleteemployeeComponent}
   ]},
  {path:"trainings",component:EmployeetrainingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


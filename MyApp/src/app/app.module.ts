import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';
import { EmployeetrainingComponent } from './employeetraining/employeetraining.component';
import { AgGridModule } from 'ag-grid-angular';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import { ModifyemployeeComponent } from './modifyemployee/modifyemployee.component';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { TopnavComponent } from './topnav/topnav.component';
import { MatDialogModule } from '@angular/material/dialog';
import { DeletedialogComponent } from './deletedialog/deletedialog.component';
import { AdddialogComponent } from './adddialog/adddialog.component';
import {MatButtonModule} from '@angular/material/button';
import { ModifydialogComponent } from './modifydialog/modifydialog.component';



@NgModule({
  declarations: [
    AppComponent,
    EmployeedetailsComponent,
    EmployeetrainingComponent,
    AddemployeeComponent,
    ModifyemployeeComponent,
    DeleteemployeeComponent,
    TopnavComponent,
    DeletedialogComponent,
    AdddialogComponent,
    ModifydialogComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    AgGridModule.withComponents([]),
    BrowserAnimationsModule,
    MatSidenavModule,
    MatListModule,
    MatDialogModule,
    MatButtonModule
 
  ],
  entryComponents:[DeletedialogComponent,AdddialogComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

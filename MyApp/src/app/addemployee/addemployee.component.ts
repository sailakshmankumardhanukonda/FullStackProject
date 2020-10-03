import { Component, OnInit } from '@angular/core';
import { addemployee } from './addemployee';
import { AddemployeeService } from './addemployee.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AdddialogComponent } from '../adddialog/adddialog.component';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {

addForm:FormGroup;
message:any;

  constructor(private addemployeeservice:AddemployeeService,private formBuilder:FormBuilder,
    private router:Router,public dialog:MatDialog) { }

  ngOnInit(): void {
         
      this.addForm=this.formBuilder.group({
       
     empId:['',Validators.required],
     firstName:['',Validators.required],
     middleName:['',Validators.required],
     lastName:['',Validators.required],
     dob:['',Validators.required],
     city:['',Validators.required],
     phoneNumber:['',Validators.required]


      });


  }


public addEmployee(){

let response=this.addemployeeservice.add(this.addForm.value);
response.subscribe((res) =>{
  this.dialog.open(AdddialogComponent,{ height: '200px', width: '600px',data:{message:res}});
   this.addForm.reset()});


}


public backToEmployeedetails(){


this.router.navigate(['details']);


}


}


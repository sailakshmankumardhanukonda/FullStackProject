import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ModifyemployeeService } from './modifyemployee.service';
import { modifyemployee } from './modifyemployee';
import { empid } from './empid';

@Component({
  selector: 'app-modifyemployee',
  templateUrl: './modifyemployee.component.html',
  styleUrls: ['./modifyemployee.component.css']
})
export class ModifyemployeeComponent implements OnInit {

  message:any;
  searchForm:FormGroup;
  modifyForm:FormGroup;
  empId:number;
  firstName:string;
  middleName:string;
  lastname:string;
  dob:Date;
  city:string;
  phoneNumber:number;



  constructor(private formBuilder:FormBuilder,private modifyemployeeservice:ModifyemployeeService) { }

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      id: ['', Validators.required]
    });
  
}


public getEmployee(){


  let response= this.modifyemployeeservice.getEmployee(this.searchForm.get("id").value);
 response.subscribe((data)=>{
   this.firstName= data.firstName,
   this.middleName=data.lastName,
   this.lastname=data.lastName;
   this.dob=data.dob,
   this.city=data.city,
   this.phoneNumber=data.phoneNumber
 });

 
 

 }

 public modifyEmployee(){

  let response=this.modifyemployeeservice.modify(this.modifyForm.value);
  response.subscribe((data) => this.message=data);


 }




}

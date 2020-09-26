import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ModifyemployeeService } from './modifyemployee.service';
import { modifyemployee } from './modifyemployee';
import { empid } from './empid';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modifyemployee',
  templateUrl: './modifyemployee.component.html',
  styleUrls: ['./modifyemployee.component.css']
})
export class ModifyemployeeComponent implements OnInit {

  message:any;
  searchForm:FormGroup;
  modifyForm:FormGroup;

  constructor(private formBuilder:FormBuilder,private modifyemployeeservice:ModifyemployeeService,
    private router : Router) { }

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      id: ['', Validators.required]
    });
    this.modifyForm=this.formBuilder.group({
      empId: null,
      firstName:'',
      middleName:'',
      lastName:'',
      dob: null,
      city:'',
      phoneNumber:null,

});
  
}


public getEmployee(){


  let response= this.modifyemployeeservice.getEmployee(this.searchForm.get("id").value);
 response.subscribe((data)=>{
   this.modifyForm.controls['empId'].setValue(data.empId),
   this.modifyForm.controls['firstName'].setValue(data.firstName),
   this.modifyForm.controls['middleName'].setValue(data.middleName),
   this.modifyForm.controls['lastName'].setValue(data.lastName),
   this.modifyForm.controls['dob'].setValue(data.dob),
   this.modifyForm.controls['city'].setValue(data.city),
   this.modifyForm.controls['phoneNumber'].setValue(data.phoneNumber)
 
  
 });

 
 

 }

 public modifyEmployee(){
  
 
  let response=this.modifyemployeeservice.modify(this.modifyForm.value);
  response.subscribe((data) => this.message=data);


 }

public backToDetails(){

this.router.navigate(['/details']);

}


}

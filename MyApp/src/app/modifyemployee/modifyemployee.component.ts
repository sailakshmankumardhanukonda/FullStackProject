import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ModifyemployeeService } from './modifyemployee.service';
import { modifyemployee } from './modifyemployee';
import { empid } from './empid';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { ModifydialogComponent } from '../modifydialog/modifydialog.component';

@Component({
  selector: 'app-modifyemployee',
  templateUrl: './modifyemployee.component.html',
  styleUrls: ['./modifyemployee.component.css']
})
export class ModifyemployeeComponent implements OnInit {

  message:any;
  hide:boolean=true;
  searchForm:FormGroup;
  modifyForm:FormGroup;

  constructor(private formBuilder:FormBuilder,private modifyemployeeservice:ModifyemployeeService,
    private router : Router,public dialog:MatDialog) { }

  ngOnInit(): void {
    this.searchForm = this.formBuilder.group({
      id: ['', Validators.required]
    });
    this.modifyForm=this.formBuilder.group({
      empId: ["",Validators.required],
      firstName:['',Validators.required],
      middleName:['',Validators.required],
      lastName:['',Validators.required],
      dob: ["",Validators.required],
      city:['',Validators.required],
      phoneNumber:["",Validators.required]

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
   this.hide=false;
  
 });

 
 

 }

 public modifyEmployee(){
  
 
  let response=this.modifyemployeeservice.modify(this.modifyForm.value);
  response.subscribe((res) => {
    this.dialog.open(ModifydialogComponent,{ height: '200px', width: '600px',data:{message:res}});
    this.modifyForm.reset();

  });
  


 }

public backToDetails(){

this.router.navigate(['/details']);

}


}


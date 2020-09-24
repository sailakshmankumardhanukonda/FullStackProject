import { Component, OnInit } from '@angular/core';
import { addemployee } from './addemployee';
import { AddemployeeService } from './addemployee.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {

addForm:FormGroup;
message:any;

  constructor(private addemployeeservice:AddemployeeService,private formBuilder:FormBuilder) { }

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
response.subscribe((data) => this.message=data);

}


}


import { Component, OnInit } from '@angular/core';
import { DeleteemployeeService } from './deleteemployee.service'
import { deleteemployee } from './deleteemployee';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-deleteemployee',
  templateUrl: './deleteemployee.component.html',
  styleUrls: ['./deleteemployee.component.css']
})
export class DeleteemployeeComponent implements OnInit {

 deleteForm:FormGroup;
  message:any;
  constructor(private deleteemployeeservice:DeleteemployeeService,private formBuilder:FormBuilder,
    private router:Router) { 

  }

 
  ngOnInit()  {
    this.deleteForm = this.formBuilder.group({
      id: ['', Validators.required]
    });
  

  }

  public deleteEmployee(){


   let response= this.deleteemployeeservice.delete(this.deleteForm.get("id").value);
  response.subscribe((data)=>this.message=data);

  }

  public backToDetails(){

   this.router.navigate(['/details']);

  }



}

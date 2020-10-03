import { Component, OnInit } from '@angular/core';
import { DeleteemployeeService } from './deleteemployee.service'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { DeletedialogComponent } from '../deletedialog/deletedialog.component';


@Component({
  selector: 'app-deleteemployee',
  templateUrl: './deleteemployee.component.html',
  styleUrls: ['./deleteemployee.component.css']
})
export class DeleteemployeeComponent implements OnInit {

 deleteForm:FormGroup;
  message:any;
  constructor(private deleteemployeeservice:DeleteemployeeService,private formBuilder:FormBuilder,
    private router:Router,public dialog:MatDialog) { 



  }

 
  ngOnInit()  {

        
  this.deleteForm = this.formBuilder.group({
    id: ['', Validators.required]
  });
   
  

  }



  public deleteEmployee(){


   let response= this.deleteemployeeservice.delete(this.deleteForm.get("id").value);
  response.subscribe((res)=>{
    this.dialog.open(DeletedialogComponent,{ height: '80px', width: '600px',data:{message:res}});
    this.deleteForm.reset();
});
  
  
    

  }

  public backToDetails(){

   this.router.navigate(['/details']);

  }
  



}

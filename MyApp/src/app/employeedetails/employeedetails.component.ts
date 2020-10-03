import { Component, OnInit } from '@angular/core';
import { EmployeedetailsService } from './employeedetails.service';
import { Router,ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-employeedetails',
  templateUrl: './employeedetails.component.html',
  styleUrls: ['./employeedetails.component.css']
})
export class EmployeedetailsComponent implements OnInit {


 private columnDefs;
 private gridApi;
 private gridColumnApi;

  constructor(private employeedetailsservice:EmployeedetailsService,private router:Router,
    public route:ActivatedRoute) { }

  ngOnInit(): void {
       
   this.columnDefs = [
      {headerName: 'Employee Id',field:"empId" ,width:150},
      {headerName: 'First Name',field:"firstName",width:150 },
      {headerName: 'Middle Name', field:"middleName",width:150},
      {headerName: 'Last Name',field:"lastName",width:150},
      {headerName: 'Date Of Birth',field:"dob",width:150 },
      {headerName: 'City',field:"city",width:150 },
      {headerName: 'Contact Number',field:"phoneNumber",width:150}
    ];

  

  }

public onGridReady(params){
  
  this.gridApi=params.api;
  this.gridColumnApi=params.columnApi;

   this.employeedetailsservice.getEmployeeDetails().subscribe((data)=>{
      
        params.api.setRowData(data)

   })


}

public goToAddEmployee():void{

  console.log("in method");
  this.router.navigate(['add'], {relativeTo: this.route } );
  
  }

public goToModifyEmployee():void{

  
     this.router.navigate(['modify'],{relativeTo: this.route });
     
}
 public goToDeleteEmployee():void{

      
       this.router.navigate(['delete'],{relativeTo: this.route });
       
}


}

import { Component, OnInit } from '@angular/core';
import { EmployeetrainingService } from './employeetraining.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-employeetraining',
  templateUrl: './employeetraining.component.html',
  styleUrls: ['./employeetraining.component.css']
})
export class EmployeetrainingComponent implements OnInit {

  
 public columnDefs;
 private gridApi;
 private gridColumnApi;
 


  constructor(private employeetrainingservice:EmployeetrainingService) { }

  ngOnInit(): void {

    this.columnDefs = [
      {headerName: 'Employee Id',field : "empId",width:175 },
      {headerName: 'Course Code',field : "courseId",width:175 },
      {headerName: 'Score',field : "score",width:175},
      {headerName: 'Hours Spent',field : "hoursSpent",width:175 },
      {headerName: 'Date Completed',field : "dateOfCompletion",width:175 },
      {headerName: 'Status',field : "status",width:175}
    ];
  


  }


  public onGridReady(params){
  
    this.gridApi=params.api;
    this.gridColumnApi=params.columnApi;
  
     this.employeetrainingservice.getTrainings().subscribe((data)=>{   
          params.api.setRowData(data)
  
     })
    }




}

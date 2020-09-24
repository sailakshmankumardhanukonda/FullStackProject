import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employeedetails',
  templateUrl: './employeedetails.component.html',
  styleUrls: ['./employeedetails.component.css']
})
export class EmployeedetailsComponent implements OnInit {

 public title:String="Employee Training Management Portal"

  constructor() { }

  ngOnInit(): void {
  }

  columnDefs = [
    {headerName: 'Employee Id' },
    {headerName: 'First Name' },
    {headerName: 'Last Name'},
    {headerName: 'Date Of Birth' },
    {headerName: 'City' },
    {headerName: 'Contact Number'}
  ];

  rowData = [
    
  ];

}

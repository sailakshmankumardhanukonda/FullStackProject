import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeedetailsService {

  constructor(private http:HttpClient) { }


public getEmployeeDetails(){


return this.http.get("http://localhost:8080/employeemanagement/employee/getall");




}



}



import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { employeetraining } from './employeetraining';

@Injectable({
  providedIn: 'root'
})
export class EmployeetrainingService {

  constructor(private http:HttpClient) { }

public getTrainings(){

return this.http.get('http://localhost:8081/employeetraining/employee/getall');


}



}

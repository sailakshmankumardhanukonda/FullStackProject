import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeetrainingService {

  constructor(private http:HttpClient) { }

public getTrainings(){

return this.http.get('http://localhost:8080/employeemanagement/training/gettrainingdetails');


}



}

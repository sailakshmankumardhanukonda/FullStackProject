import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { addemployee } from './addemployee'

@Injectable({
  providedIn: 'root'
})
export class AddemployeeService {

  constructor(private http:HttpClient) { }

  public add(emp:addemployee){

  

    return this.http.post('http://localhost:8080/employeemanagement/employee/create',emp,{responseType: 'text' as 'json'});
    
    
    
    }





}


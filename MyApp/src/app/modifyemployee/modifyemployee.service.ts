import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { modifyemployee } from './modifyemployee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModifyemployeeService {

  constructor(private http:HttpClient) { }


  public getEmployee(id:number):Observable<modifyemployee>{

return this.http.get<modifyemployee>('http://localhost:8080/employee/get/'+id);

  }

  public modify(emp:modifyemployee){


return this.http.put('http://localhost:8080/employee/update',emp,{responseType: 'text' as 'json'});

  }


}

import { Injectable } from '@angular/core';
import { Observable, throwError  } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class DeleteemployeeService {

  constructor(private http: HttpClient) { }

public delete(id:string){

  

return this.http.delete('http://localhost:8080/employee/delete/'+id,{responseType: 'text' as 'json'});



}


}

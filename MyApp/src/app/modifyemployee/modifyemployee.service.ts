import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { modifyemployee } from './modifyemployee';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ModifyemployeeService {

  constructor(private http:HttpClient) { }


  public getEmployee(id:number){

return this.http.get<modifyemployee>('http://localhost:8080/employeemanagement/employee/get/'+id).pipe(catchError(this.handleError));

  }

  public modify(emp:modifyemployee){


return this.http.put('http://localhost:8080/employeemanagement/employee/update',emp,{responseType: 'text' as 'json'});

  }


  private handleError(err: HttpErrorResponse) {
    let errMsg = '';
    if (err.error instanceof Error) {
      // A client-side or network error occurred. Handle it accordingly.
      console.log('An error occurred:', err.error.message);
      errMsg = err.error.message;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.log(`Backend returned code ${err.status}`);
      errMsg = JSON.stringify(err.error);
      console.log(JSON.stringify(err.error));
    }
    return throwError(err);
  }
  



}

import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { addemployee } from './addemployee'
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AddemployeeService {

  constructor(private http:HttpClient) { }

  public add(emp:addemployee){

  

    return this.http.post('http://localhost:8080/employeemanagement/employee/create',emp,{responseType: 'text' as 'json'}).pipe(catchError(this.handleError));
    
    
    
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


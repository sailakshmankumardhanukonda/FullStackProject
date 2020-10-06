import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeedetailsService {

  constructor(private http:HttpClient) { }


public getEmployeeDetails(){
  
return this.http.get("http://localhost:8080/employeemanagement/employee/getall").pipe(catchError(this.handleError));




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
    errMsg = err.error.status;
  }
  return throwError(errMsg);
}



}



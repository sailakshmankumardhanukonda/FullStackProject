import { Injectable } from '@angular/core';
import { Observable, throwError  } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class DeleteemployeeService {

  constructor(private http: HttpClient) { }

public delete(id:string){

  

return this.http.delete('http://localhost:8080/employeemanagement/employee/delete/'+id,{responseType: 'text' as 'json'}).pipe(catchError(this.handleError));



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

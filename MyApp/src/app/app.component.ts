import { Component, OnInit } from '@angular/core';
import { DeleteemployeeComponent } from './deleteemployee/deleteemployee.component';
import { AppService } from './app.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MyApp';
  message:any;

 
}

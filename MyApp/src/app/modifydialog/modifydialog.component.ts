import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modifydialog',
  templateUrl: './modifydialog.component.html',
  styleUrls: ['./modifydialog.component.css']
})
export class ModifydialogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public message:any,private router:Router) { }

  ngOnInit(): void {
  }


  
  public onDialogClose(){


    this.router.navigate(['details']);
  
    }

}

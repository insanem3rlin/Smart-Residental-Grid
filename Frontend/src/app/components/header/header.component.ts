import { Component } from '@angular/core';
import {Subscription} from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  title:string = 'Smart Residental Grid';
  showAddTask: boolean;
  subscription: Subscription;
  
  constructor() {
    
  }

  ngOnInit(): void {}
}

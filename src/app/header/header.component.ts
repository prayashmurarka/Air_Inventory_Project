import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserviceService } from '../uservice.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  isUserLoggedIn = false;
  isLoggedIn: boolean = false;
  constructor(private route:Router,private http:HttpClient,private service:UserviceService) {
    this.isLoggedIn=this.service.getIsUserLoggedIn();

   }
   setIsUserLoggedIn()
   {
    this.isUserLoggedIn=true;
   }
   getIsUserLoggedIn()
   {
    return this.isUserLoggedIn;
   }
  logout() {
    // this.st.setIsUserLoggedIn(false);
    alert("signout successful");
    this.route.navigateByUrl('');
  }
}

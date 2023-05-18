import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserviceService } from '../uservice.service';

@Component({
  selector: 'app-user-header',
  templateUrl: './user-header.component.html',
  styleUrls: ['./user-header.component.css']
})
export class UserHeaderComponent implements OnInit{
  isUserLoggedIn = false;
  isLoggedIn: boolean = false;
  constructor(private router:Router,private http:HttpClient,private service:UserviceService) {
    this.isLoggedIn=this.service.getIsUserLoggedIn();

   }
  ngOnInit(): void {
    
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
    this.router.navigateByUrl('');
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
function _window() : any {
  return window;
}

@Injectable({
  providedIn: 'root'
})
export class UserviceService {
  get nativeWindow() : any {
    return _window();
  }

  isUserLoggedIn = false;
  constructor(private router:Router,private http:HttpClient) {
    this.isUserLoggedIn=false;
   }
   setIsUserLoggedIn()
   {
    this.isUserLoggedIn=true;
   }
   getIsUserLoggedIn()
   {
    return this.isUserLoggedIn;
   }
  

  addUser(user: any) {
    return this.http.post('/products/user', user);
  }

  getAllUser(){
    return this.http.get('/products/user/list')
  }
  
}
import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { Router } from '@angular/router';
import { UserviceService } from '../uservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  id:any;
  password:any;
  newuser:any={};
  showForm: boolean = false;
  
  
    constructor(private service:UserviceService,private route:Router,private uservice:UserviceService) 
    {}
    //Register New User
    addUser(){
      this.showForm=true;
    }
    addNewUser() {
      return this.service.addUser(this.newuser).subscribe((data: any) => {
      console.log(data);
      alert("success");
      this.newuser = {};
      this.ngOnInit();
      console.log("New User Added");
      });
    }
  
    ///////////////////////login/////////////////

    loginData:any;
    allUser:any[]=[];
    isloggendin= false;
    

    getAllUsers(){
      return this.service.getAllUser().subscribe((data:any)=>{
        this.allUser = data;
      });
    }
    loginDetails(formdata:any)
    {
      let nemail = formdata.email;
      let npassword = formdata.password;
      console.log(formdata);
      if(formdata.email=="admin" && formdata.password=="admin")
      {
        alert("Admin login success");
        this.uservice.setIsUserLoggedIn();
        this.route.navigateByUrl('header');
      }
      else{
        var count=0;
        for (let user of this.allUser){
          
          if (user.email === nemail && user.password === npassword){

              this.uservice.setIsUserLoggedIn();  //true
              alert("Authorized User");
              this.route.navigateByUrl('uheader');
              count = count+1;
          }
        }
        if(count ==0){
          alert("Wrong Credentials");
        }
      }
      
    }

  ngOnInit(): void {
    this.getAllUsers();
  }    

  //local storage

}
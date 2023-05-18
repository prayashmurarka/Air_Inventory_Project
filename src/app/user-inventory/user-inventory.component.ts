import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { Router } from '@angular/router';
import { UserviceService } from '../uservice.service';

@Component({
  selector: 'app-user-inventory',
  templateUrl: './user-inventory.component.html',
  styleUrls: ['./user-inventory.component.css']
})
export class UserInventoryComponent implements OnInit {

  product:any;
  isLoggedIn: boolean = false;
  showform: boolean=false;
  constructor(private service:ServiceService,private route:Router,private uservice:UserviceService){
    this.isLoggedIn = this.uservice.getIsUserLoggedIn();
  }
  ngOnInit(): void {
   this.getProductlist();
  }
  getProductlist(){
    return this.service.getproductList().subscribe((data:any)=>
    {
      this.product=data;
    })
  }
  logout() {
    // this.st.setIsUserLoggedIn(false);
    alert("signout successful");
    this.route.navigateByUrl('');
  }
Addaddress(){
this.showform=true;
}
  options = {
      "key": "rzp_test_M47RbQNk904fv5", // Enter the Key ID generated from the Dashboard
      "amount": "50000", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
      "currency": "INR",
      "name": "Ainventory", //your business name
      "description": "Test Transaction",
      "image": "http://www.newdesignfile.com/postpic/2014/06/icon-air-airline-photos_63759.png",
      "order_id": "", //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
      "callback_url": "https://eneqd3r9zrjok.x.pipedream.net/",
      "prefill": {
          "name": "Gaurav Kumar", //your customer's name
          "email": "gaurav.kumar@example.com",
          "contact": "9000090000"
      },
      "notes": {
          "address": "Razorpay Corporate Office"
      },
      "theme": {
          "color": "#3399cc"
      }
  };
  rzp1:any;
  paying(){
    this.rzp1 = new this.uservice.nativeWindow.Razorpay(this.options);
    this.rzp1.open();
    
  }

  
}
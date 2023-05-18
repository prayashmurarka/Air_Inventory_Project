import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { UserviceService } from '../uservice.service';
@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit{
  product:any;
 user:any;
 
  showForm: boolean = false;
  newproduct: any={};
  isLoggedIn: boolean=false;
  isUserLoggedIn = false;
  constructor(private service:ServiceService,private route:Router,private uservice:UserviceService ){
    this.isLoggedIn=this.uservice.getIsUserLoggedIn();
  }
  
  
  
   setIsUserLoggedIn()
   {
    this.isUserLoggedIn=true;
   }
   getIsUserLoggedIn()
   {
    return this.isUserLoggedIn;
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

  //insert product
  addProduct(){
    this.showForm=true;
  }

  addNewProduct() {
    return this.service.addProduct(this.newproduct).subscribe((data: any) => {
      console.log(data);
      this.newproduct = {};
      this.ngOnInit();
    });
  }
  
  //delete product
  delPro(id:any)
  {
    return this.service.deleteProduct(id).subscribe((data:any)=>
    {
      console.log(data);
      this.ngOnInit();
    })
  }
  //update product
  selectedProduct:any;
    updateProduct() {
    return this.service.updateProduct(this.selectedProduct).subscribe((data: any) => {
      console.log(data);
      this.selectedProduct = null;
      this.ngOnInit();
    });
  }
  editProduct(product: any) {
    this.selectedProduct = product;
  }
  
  logout() {
    // this.st.setIsUserLoggedIn(false);
    alert("signout successful");
    this.route.navigateByUrl('');
  }
}

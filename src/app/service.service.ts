import { Injectable } from '@angular/core';
import { Route } from '@angular/router';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private router:Router,private http:HttpClient) { 

  }

  getproductList()
  {
    return this.http.get("/products/list"); //"http://localhost:8080//
  }
  
  addProduct(product: any) {
    return this.http.post('/products/list', product);
  }
 
  deleteProduct(id:any)
  {
   return this.http.delete("/products/list/"+id);
  }

  updateProduct(product:any){
    return this.http.put("/products/list", product);
  }
 
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class CserviceService {

  constructor(private router:Router,private http:HttpClient) { 

  }

  getcategoryList()
  {
    return this.http.get("products/category/list");
  }
  
  
  addCategory(category: any) {
    return this.http.post('products/category/list', category);
  }
  

  deleteCategory(id:any)
  {
   return this.http.delete("products/category/list/"+id);
  }

  updateCategory(category:any){
    return this.http.put("products/category", category);
  }
}

import { Component } from '@angular/core';
import { ServiceService } from '../service.service';
import { Router } from '@angular/router';
import { CserviceService } from '../cservice.service';
import { UserviceService } from '../uservice.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {
  category:any;
 
  isUserLoggedIn = false;
  showForm: boolean = false;
  newcategory: any={};
  selectedCategory: any;
  isLoggedIn: boolean = false;
constructor(private cservice:CserviceService,private route:Router,private service:UserviceService){
  this.isLoggedIn=this.service.getIsUserLoggedIn();
}
  ngOnInit(): void {
   this.getCategorylist();
  }
  getCategorylist(){
    return this.cservice.getcategoryList().subscribe((data:any)=>
  {
    this.category=data;
  })
  }

 
  

  addCategory(){
    this.showForm=true;
  }

  addNewCategory() {
    return this.cservice.addCategory(this.newcategory).subscribe((data: any) => {
      console.log(data);
      this.newcategory = {};
      this.ngOnInit();
    });
  }
  
  delcategory(id:any)
  {
    return this.cservice.deleteCategory(id).subscribe((data:any)=>
    {
      console.log(data);
      this.ngOnInit();
    })
  }
selectedProduct:any;
  updateCategory() {
    return this.cservice.updateCategory(this.selectedCategory).subscribe((data: any) => {
      console.log(data);
      this.selectedCategory = null;
      this.ngOnInit();
    });
  }
  editCategory(category: any) {
    this.selectedCategory = category;
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

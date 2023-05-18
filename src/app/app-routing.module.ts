import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { InventoryComponent } from './inventory/inventory.component';
import { CategoryComponent } from './category/category.component';
import { LoginComponent } from './login/login.component';
import { UserHeaderComponent } from './user-header/user-header.component';
import { UserInventoryComponent } from './user-inventory/user-inventory.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  
  {path:"header",component:HeaderComponent},
  {path:"inventory",component:InventoryComponent},
  {path:"category",component:CategoryComponent},
  {path:"uheader",component:UserHeaderComponent},
  {path:"uinventory",component:UserInventoryComponent},
  {path:"header/inventory",component:InventoryComponent},
  {path:"header/category",component:CategoryComponent},
  {path:"header/header",component:HeaderComponent},
  {path:"header/login",component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  
  exports: [RouterModule]
})
export class AppRoutingModule { }

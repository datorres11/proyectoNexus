import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminCommodityComponent } from './components/admin-commodity/admin-commodity.component';
import { AdminPositionComponent } from './components/admin-position/admin-position.component';
import { AdminUserComponent } from './components/admin-user/admin-user.component';


const routes: Routes = [
  {path:'comodity', component:AdminCommodityComponent},
  {path:'position', component:AdminPositionComponent},
  {path:'user', component:AdminUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

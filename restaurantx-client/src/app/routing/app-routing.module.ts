import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from '../component/login/login.component';
import {HomeComponent} from '../component/home/home.component';
import {AuthGuard} from '../service/authentication-guard/AuthGuard';
import {RegisterComponent} from '../component/register/register.component';

const routes: Routes = [{
  path: 'restaurantx/login', component: LoginComponent
},
  {
    path: 'restaurantx/register', component: RegisterComponent
  },
  {
    path: 'restaurantx',
    canActivate: [AuthGuard],
    component: HomeComponent,
    // children:
    //   []
  }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

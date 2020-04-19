import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {AuthService} from '../authentication/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  private baseURL = '/restaurantx/login';

  constructor(private router: Router, private authService: AuthService) {
  }

  public canActivate(): boolean {
    if (this.authService.isLoggedIn()) {
      return true;
    }
    this.router.navigate([this.baseURL]);
    return false;
  }

}

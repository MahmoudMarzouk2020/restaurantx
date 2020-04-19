import {Injectable, Injector} from '@angular/core';
import {User} from '../../model/user/user';
import {HttpClient} from '@angular/common/http';
import {ServerService} from '../server/server.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public user: User;
  private http: HttpClient;
  private serverService: ServerService;

  constructor(injector: Injector) {
    this.http = injector.get(HttpClient);
    this.serverService = injector.get(ServerService);
  }

  public isLoggedIn() {
    let result = false;
    const token = localStorage.getItem('restaurantxAccess');
    if (token !== null && token.length > 0) {
      result = true;
    }
    return result;
  }

  public login(emailParam: string, passwordParam: string) {
    return this.http.post(this.serverService.loginAPI, {email: emailParam, password: passwordParam});
  }

  public setToken(token) {
    localStorage.setItem('restaurantxAccess', token);
  }

  public setUserFullName(userFullName) {
    localStorage.setItem('restaurantxUserFullName', userFullName);
  }

  public getUserFullName() {
    return localStorage.getItem('restaurantxUserFullName');
  }

  public logout() {
    localStorage.removeItem('restaurantxAccess');
  }

}

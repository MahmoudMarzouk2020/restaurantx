import {Component, Injector, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../service/authentication/auth.service';
import {User} from '../../model/user/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public falseLoginAttempt: boolean;
  public serverDown: boolean;
  private router: Router;
  private authenticationService: AuthService;

  constructor(injector: Injector) {
    this.router = injector.get(Router);
    this.authenticationService = injector.get(AuthService);
  }

  ngOnInit(): void {
    if (this.authenticationService.isLoggedIn()) {
      this.goToHome();
    }
  }

  private goToHome() {
    const booleanPromise = this.router.navigate(['restaurantx']);
  }

  login(emailInputElement: HTMLInputElement, passwordInputElement: HTMLInputElement) {
    const email = emailInputElement.value;
    const password = passwordInputElement.value;

    this.authenticationService.login(email, password)
      .subscribe(response => {
        const token = (response as { accessToken: string }).accessToken;
        this.authenticationService.setToken(token);
        this.authenticationService.user = (response as { userPrincipal: User }).userPrincipal;
        this.authenticationService.setUserFullName(this.authenticationService.user.firstName
          + ' ' + this.authenticationService.user.lastName);
        this.goToHome();
      }, err => {
        if (err.status === 0) {
          this.serverDown = true;
        } else {
          this.authenticationService.logout();
          this.falseLoginAttempt = true;
        }
      });
  }

}

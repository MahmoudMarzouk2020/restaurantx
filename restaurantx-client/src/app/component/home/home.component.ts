import {Component, Injector, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../service/authentication/auth.service';
import {User} from '../../model/user/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private router: Router;
  public authenticationService: AuthService;
  public userFullName: string;
  public isReservationProcess: boolean;

  constructor(injector: Injector) {
    this.router = injector.get(Router);
    this.authenticationService = injector.get(AuthService);
  }

  ngOnInit(): void {
    if (!this.authenticationService.isLoggedIn()) {
      this.goToLoginPage();
    }
    this.userFullName = localStorage.getItem('restaurantxUserFullName');
  }

  private goToLoginPage() {
    const booleanPromise = this.router.navigate(['restaurantx/login']);
  }

  logout() {
    this.authenticationService.logout();
    location.reload();
  }

}

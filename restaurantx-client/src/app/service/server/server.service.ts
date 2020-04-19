import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServerService {
  private serverIp = '127.0.0.1';
  private serverPort = '9091';

  // Authentication
  public registerAPI = 'http://' + this.serverIp + ':' + this.serverPort + '/restaurantx/api/auth/register';
  public loginAPI = 'http://' + this.serverIp + ':' + this.serverPort + '/restaurantx/api/auth/login';

  // Customer APIs
  public getAvailableTablesAPI = 'http://' + this.serverIp + ':' + this.serverPort + '/restaurantx/api/cust/available-tables';
  public bookTableAPI = 'http://' + this.serverIp + ':' + this.serverPort + '/api';

  // Admin APIs
  public getAllTablesAPI = 'http://' + this.serverIp + ':' + this.serverPort + '/admin/api';
  public addTableAPI = 'http://' + this.serverIp + ':' + this.serverPort + '/admin/api';
  public getAllReservationsAPI = 'http://' + this.serverIp + ':' + this.serverPort + '/admin/api';

  constructor() {
  }

  prepareGetAvailableTablesAPI(dateTime, noOfPersons) {
    const apiQuery = '?dateTime=' + dateTime + '&persons=' + noOfPersons;
    return this.getAvailableTablesAPI + apiQuery;
  }

}

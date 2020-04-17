import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServerService {
  private serverIp = '127.0.0.1';
  private serverPort = '9091';

  // Authentication
  public loginAPI = 'http://' + this.serverIp + ':' + this.serverPort + '/api/authentication/admin/signin';

  // User APIs
  public getAvailableTables = 'http://' + this.serverIp + ':' + this.serverPort + '/api';
  public bookTable = 'http://' + this.serverIp + ':' + this.serverPort + '/api';

  // Admin APIs
  public getAllTables = 'http://' + this.serverIp + ':' + this.serverPort + '/admin/api';
  public addTable = 'http://' + this.serverIp + ':' + this.serverPort + '/admin/api';

  constructor() {
  }

}

import {Component, Injector, OnInit} from '@angular/core';
import {DatePipe} from '@angular/common';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ServerService} from '../../../service/server/server.service';
import {RestaurantTable} from '../../../model/table/RestaurantTable';
import {HomeComponent} from '../home.component';

@Component({
  selector: 'app-available-tables',
  templateUrl: './available-tables.component.html',
  styleUrls: ['./available-tables.component.css']
})
export class AvailableTablesComponent implements OnInit {
  private datePipe: DatePipe;
  public dateTime: Date;
  public noOfPersons: number;
  private http: HttpClient;
  private serverService: ServerService;
  public availableTables: RestaurantTable[];

  constructor(injector: Injector) {
    this.datePipe = injector.get(DatePipe);
    this.dateTime = new Date();
    this.http = injector.get(HttpClient);
    this.serverService = injector.get(ServerService);
  }

  ngOnInit(): void {
  }

  setDate(dateEl) {
    const dateString = new Date((dateEl as HTMLInputElement).value);
    this.dateTime.setFullYear(dateString.getFullYear(), dateString.getMonth(), dateString.getDate());
  }

  setHour(hourEl) {
    const hour = (hourEl as HTMLInputElement).value;
    this.dateTime.setHours(Number(hour));
  }

  setMin(minEl) {
    const min = (minEl as HTMLInputElement).value;
    this.dateTime.setMinutes(Number(min), 0);
  }

  setNoOfPersons(target) {
    this.noOfPersons = Number((target as HTMLInputElement).value);
  }

  checkAvailableTables() {
    const dateTimeToCheck = this.datePipe.transform(this.dateTime, 'dd-MM-yyyy-HH:mm:ss');
    const getAvailableTablesApiUrl = this.serverService.prepareGetAvailableTablesAPI(dateTimeToCheck, this.noOfPersons);
    const httpHeaders = new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('restaurantxAccess'));
    this.http.get(getAvailableTablesApiUrl, {headers: httpHeaders})
      .subscribe(response => {
        this.updateAvailableTables((response as { availableRestaurantTables: RestaurantTable[] }).availableRestaurantTables);
      });
  }

  updateAvailableTables(tables: RestaurantTable[]) {
    this.availableTables = tables;
  }

  startReservation() {
    // HomeComponent
  }

}

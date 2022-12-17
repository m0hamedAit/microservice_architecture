import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private http:HttpClient) { }

  public getCustomers(): any {
    return this.http.get<any>(environment.api + '/customer-service/customers?projection=fullCustomer');
  }
}

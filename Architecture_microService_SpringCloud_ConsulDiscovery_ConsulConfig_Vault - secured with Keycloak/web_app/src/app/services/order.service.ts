import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  public getCustomerOrders(id:number): any {
    return this.http.get<any>(environment.api + '/order-service/orders/search/byCustomerId?customerId=' + id + '&projection=fullOrder');
  }

  public getOrderProducts(id:number): any {
    return this.http.get<any>(environment.api + '/order-service/fullOrder/'+id);
  }

}

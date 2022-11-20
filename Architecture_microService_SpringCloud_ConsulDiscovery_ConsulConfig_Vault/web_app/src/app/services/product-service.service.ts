import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http:HttpClient) { }

  public getProducts(): any {
    return this.http.get<any>(environment.api + '/inventory-service/products?projection=fullProduct');
  }

}

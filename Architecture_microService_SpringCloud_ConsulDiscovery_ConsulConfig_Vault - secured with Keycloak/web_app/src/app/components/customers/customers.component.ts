import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from 'src/app/services/customer-service.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})

export class CustomersComponent implements OnInit {

  customers!: any[];

  constructor(private customerService: CustomerServiceService) { }

  ngOnInit(): void {
    this.customerService.getCustomers().subscribe((data: { _embedded: { customers: any[]; }; }) => {
      this.customers = data._embedded.customers;
    });
  }

  editCustomer(customer: any) {
    //
  }

  deleteCustomer(customer: any) {
    //
  }
}
import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from 'src/app/services/customer-service.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  
  customers!: Customer[];
  orders!: any[];
  products!: any[];
  selectedCustomer!: any;
  selectedOrder: any;

  constructor(private customerService:CustomerServiceService, private orderService: OrderService) {}

  ngOnInit(): void {
    this.customerService.getCustomers().subscribe((data: { _embedded: { customers : any[]; }; }) => {
      this.customers = data._embedded.customers;
    }
    );
  }

  getOrders() {
    if (this.selectedCustomer) {
      this.orderService.getCustomerOrders(this.selectedCustomer.id).subscribe((data: { _embedded: { orders: any[]; }; }) => {
        console.log(data._embedded.orders);
        this.orders = data._embedded.orders;
      });
      
    }
  }

  getProducts() {
    console.log(this.selectedOrder.id);
    if (this.selectedOrder) {
      this.orderService.getOrderProducts(this.selectedOrder.id).subscribe((data: { productItems: any[]; }) => {
        console.log(data.productItems);
        this.products = data.productItems;
      
      });
    }
  }



}


interface Customer {
  name: string,
  id: number, 
  email: string,
}

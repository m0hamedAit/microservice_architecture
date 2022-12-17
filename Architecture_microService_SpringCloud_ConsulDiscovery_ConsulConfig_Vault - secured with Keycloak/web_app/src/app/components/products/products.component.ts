import { Component, OnInit } from '@angular/core';
import { SortEvent } from 'primeng/api';
import { ProductServiceService } from 'src/app/services/product-service.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products!: any[];

  constructor(private productService: ProductServiceService) { }

  ngOnInit(): void {
    this.productService.getProducts().subscribe((data: { _embedded: { products: any[]; }; }) => {
      this.products = data._embedded.products;
    });
  }

  editProduct(product: any) {
    //
  }

  deleteProduct(product: any) {
    //
  }

}

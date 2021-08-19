import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  constructor(private service: ProductService) { }

  products: Product[] = [];

  ngOnInit(): void {

    this.service.fetchAllPizzaService()
        .subscribe( data => {
          this.products = data;
        })
  }

}

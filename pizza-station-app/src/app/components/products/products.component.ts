import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Cart, items } from 'src/app/models/cart';
import { Product } from 'src/app/models/Product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  constructor(private service: ProductService, private route: ActivatedRoute,
    private cartService: CartService) { }

  products: Product[] = [];


  ngOnInit(): void {

    this.service.fetchAllPizzaService()
        .subscribe( data => {
          this.products = data;
        });

    
  }

  public addToCart(product: Product){
      // console.table(product);
      this.cartService.addToCart(product);

  }

}

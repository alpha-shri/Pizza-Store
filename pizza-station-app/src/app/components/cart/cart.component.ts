import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  public cartItems: any[] = [];

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.cartService
        .getProducts().subscribe( data => {
          this.cartItems = data;
          console.log(data);
          
          // console.table(this.cartItems);
        });
  }

  public emptyCart(){
    this.cartService.emptyCart();

  }

}

import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Cart } from '../models/cart';
import { Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItemList: Cart[] = [];

  public cartBehaviour = new BehaviorSubject<any>([]);

  constructor() { }


  getProducts(){
    return this.cartBehaviour.asObservable();
  }

  setProducts(product: any){

    this.cartItemList.push(...product);


    this.cartBehaviour.next(product);
  }

  public addToCart(product: Product){

      const newCart: Cart = {
        product: product,
        quantity: 1
      }
      console.log("Product: ", product);
      

      this.cartItemList.forEach( data => {
          if( data.product.id === product.id ){
              data.quantity =+ 1;
          }else{
              this.cartItemList.push(newCart);
          }
      });

      this.cartBehaviour.next(this.cartItemList);
  }

  public getTotalCost(){

    let grandTotal: number = 0;

    this.cartItemList.map( (a: any) => {
        grandTotal += a.total;
    })
  }

  public emptyCart(){
    this.cartItemList.length = 0;
    this.cartBehaviour.next(this.cartItemList);
  }

}

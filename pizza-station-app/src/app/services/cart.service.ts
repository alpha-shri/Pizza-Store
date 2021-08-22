import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartBehaviour = new BehaviorSubject<any>([]);

  constructor() { }

  public addToCart(product: any){
    this.cartBehaviour.next(product);
  }

}

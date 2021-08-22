import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItemList: any = [];

  public cartBehaviour = new BehaviorSubject<any>([]);

  constructor() { }


  getProducts(){
    return this.cartBehaviour.asObservable();
  }

  setProducts(product: any){
    this.cartItemList.push(...product);
    this.cartBehaviour.next(product);
  }

  public addToCart(product: any){
      this.cartItemList.push(product);
      this.cartBehaviour.next(this.cartItemList);
  }

  public getTotolCost(){

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

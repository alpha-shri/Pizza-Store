import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Product } from 'src/app/models/Product';
import { ProductService } from 'src/app/services/product.service';


@Component({
  selector: 'app-pizza-details',
  templateUrl: './pizza-details.component.html',
  styleUrls: ['./pizza-details.component.scss']
})
export class PizzaDetailsComponent implements OnInit {

  id: Number = 101;

  product: Product = <Product>{};

  constructor(private route: ActivatedRoute, private service: ProductService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    console.log(this.route.snapshot.params.id);

    this.service.fetchByIdService(this.id)
                .subscribe( data => {
                    this.product = data;
                });
  }

}

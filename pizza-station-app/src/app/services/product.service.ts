import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private BASE_URL = 'http://localhost:5000/pizza-service';

  constructor(private http: HttpClient) { }

  fetchAllPizzaService(): Observable<Product[]>{
    return this.http.get<Product[]>(this.BASE_URL + '/fetchall');
  }

  fetchByIdService(id: Number): Observable<Product>{
    return this.http.get<Product>(this.BASE_URL+ '/find/' +id);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url_fetchAll = 'http://localhost:5000/pizza-service/fetchall';

  constructor(private http: HttpClient) { }

  fetchAllPizzaService(): Observable<Product[]>{
    return this.http.get<Product[]>(this.url_fetchAll);
  }
}

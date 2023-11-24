import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Bread} from "../../models/Bread";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BreadService {

  constructor(private httpClient: HttpClient) {

  }


  getAllBread() :Observable<Array<Bread>>{
    return this.httpClient.get<Array<Bread>>("http://localhost:8080/api/all");

  }

  updateOrders(bread: Bread){
    return this.httpClient.post<Bread>("http://localhost:8080/api/update",bread)
  }
}

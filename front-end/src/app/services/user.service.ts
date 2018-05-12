import 'rxjs/Rx';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

@Injectable()
export class UserService {
  private customer: User;
  constructor(private h: HttpClient, private router: Router) { }

  logIn(u: User) {
    const url = '/login';
    return this.h.post(url, u.toJSON());

  }

  register(u: User){
    const url = "/addUser";
    return this.h.post(url, u.toJSON());
  }

  setCustomer(c: User) {
    this.customer = c;
  }

  getCustomer(): User {
    return this.customer;
  }

  requestStore(store){
    const url = "/requestStore";
    let data = {
      "store":store, "user":this.customer
    };
    console.log(data);
    return this.h.post(url, data);
  }

  getProducts(S){
    const url = "/getStoreProducts";

    return this.h.post(url, S);
  }

  getStores(){
    const url = "/showAllStores";
    return this.h.post(url, "");
  }

  view(s){
    const url = "/viewProduct";
    this.h.post(url, {
      id: s.id,
      name: s.name
    });
  }

  buy(s){
    const url = "/buyProduct";
    this.h.post(url, s); 
  }

}

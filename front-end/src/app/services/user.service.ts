import { Customer } from '../models/customer';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

@Injectable()
export class UserService {
  private customer: Customer;
  constructor(private h: HttpClient, private router: Router) { }

  logIn(u: User) {
    const url = '/login/customer/?name=' + u.name + '&' + 'password=' + u.password;
    return this.h.get(url);

  }

  setCustomer(c: Customer) {
    this.customer = c;
  }

  getCustomer(): Customer {
    return this.customer;
  }
}

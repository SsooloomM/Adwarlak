import { Customer } from '../models/customer';
import { User } from '../models/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class UserService {

  constructor(private h: HttpClient) { }

  getCustomer(u: User): Customer {
    const url = '/login/customer/?name=' + u.name + '&' + 'password=' + u.password;

    this.h.get(url).subscribe(
      data =>  {
        console.log('=>', data);
      }
    );

    return null;
  }
}

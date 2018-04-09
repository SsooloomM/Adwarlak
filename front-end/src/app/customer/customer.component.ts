import { Customer } from '../models/customer';
import { UserService } from '../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  private me: Customer;

  constructor(private service: UserService) {
    this.me = service.getCustomer();
  }

  ngOnInit() {
  }

}

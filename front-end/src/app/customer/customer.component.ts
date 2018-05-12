import { Product } from './../models/product';
import { Store } from './../models/store';
import { User } from '../models/user';
import { UserService } from '../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  private me: User;
  private stores: any;
  private products: any;

  constructor(private service: UserService) {
    this.me = service.getCustomer();
    this.stores = [];
    this.getStores();
  }

  ngOnInit() {
  }

  requestStore(formData){
    let store = {
      name: formData.name,
      location: formData.location,
      type: formData.storeType
    };

    this.service.requestStore(store);

  }

  showProducts(S){
    let temp = this.service.getProducts(S).subscribe(
      res =>{
        this.products = res;
        console.log(' ---------> ', res);
      }
    )
    console.log(this.products);
  }

  viewProduct(storeProduct){
    this.service.view(storeProduct);
  }

  buyProduct(storeProduct){
    this.service.buy(storeProduct);
  }

  getStores() {
    let temp = this.service.getStores().subscribe(
      res=>{
        this.stores = res;
        console.log(' ---------> ', res);
      }
    );
  }

}

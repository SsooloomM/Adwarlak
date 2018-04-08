import { User } from '../models/user';
import { UserService } from '../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {


  loginType: string;
  registerType: string;
  user: User;

  constructor(private service: UserService) {
    this.loginType = 'shopOwner';
    this.registerType = 'shopOwner';
    this.user = new User();
  }

  ngOnInit() {
  }

  loginTypeChanged() {
  
  }
  registerTypeChanged() {
  
  }

  register(data) {
    this.user.name = data.name;
    this.user.password = data.pass;
    console.log(this.user);
    return false;

  }

  logIn(data) {
    this.user.name = data.name;
    this.user.password = data.pass;
    this.service.getCustomer(this.user);
    console.log(this.user);
    return false;
  }
}

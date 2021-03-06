import { User } from '../models/user';
import { UserService } from '../services/user.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {


  loginType: string;
  registerType: string;
  user: User;

  constructor(private service: UserService, private router: Router) {
    this.loginType = 'shopOwner';
    this.registerType = 'shopOwner';
    this.user = new User();
  }

  ngOnInit() {
  }

  register(formData) {
    this.user.$name = formData.name;
    this.user.$password = formData.pass;
    console.log(this.user);

    let temp, c: User;
      temp = this.service.register(this.user);
      temp.subscribe(
        data =>  {
          console.log(' ---------> ', data);
          if ( data !== '' && data !== null) {
            c = new User();
            c.setData(data);
            this.service.setCustomer(c);
            console.log('\/\/\/\/\/\/\/\//\/', c);
            this.router.navigate(['customer']);
          }
        }
      );
      if (temp === null) {
        return false;
      }

  }

  logIn(formData) {
    this.user.$name = formData.name;
    this.user.$password = formData.pass;
    if (this.loginType === 'user') {
      let temp, c: User;
      temp = this.service.logIn(this.user);
      temp.subscribe(
        data =>  {
          console.log(' ---------> ', data);
          if ( data !== '' && data !== null) {
            c = new User();
            c.setData(data);
            this.service.setCustomer(c);
            console.log('\/\/\/\/\/\/\/\//\/', c);
            this.router.navigate(['customer']);
          }
        }
      );
      if (temp === null) {
        return false;
      }
    }
    return false;
  }
}

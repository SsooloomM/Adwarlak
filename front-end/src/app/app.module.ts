import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, Http } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';

import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { UserService } from './services/user.service';
import { CustomerComponent } from './customer/customer.component';
import { TitleComponent } from './title/title.component';

import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: FormComponent
  },
  {
    path: 'customer',
    component: CustomerComponent,
  }
];

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    CustomerComponent,
    TitleComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    UserService,
    HttpClient
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

export class Customer {
  private id: number;
  private name: string;
  private password: string;

  constructor (Data) {
    this.id = Data.id;
    this.name = Data.userName;
    this.password = Data.password;
  }
}

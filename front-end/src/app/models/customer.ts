export class Customer {
  private id: number;

  constructor (
    public userName: string,
    public password: string
  ) {
    this.id = null;
  }
}

import { Operation } from './Operation';
import { User } from "./user";
import { StoreProduct } from "./StoreProduct";

export class Store {
    private id: number;
	private name: string;
	private type: string;
	private location: string;
	private onSystem: boolean;
	
	private storeProducts: StoreProduct;
    private owner: User;
	
	private collaborators: User[];
	
	private operations: Operation[];
  
  

    /**
     * Getter $type
     * @return {string}
     */
	public get $type(): string {
		return this.type;
	}

    /**
     * Setter $type
     * @param {string} value
     */
	public set $type(value: string) {
		this.type = value;
	}

    /**
     * Getter $location
     * @return {string}
     */
	public get $location(): string {
		return this.location;
	}

    /**
     * Setter $location
     * @param {string} value
     */
	public set $location(value: string) {
		this.location = value;
	}

    /**
     * Getter $onSystem
     * @return {boolean}
     */
	public get $onSystem(): boolean {
		return this.onSystem;
	}

    /**
     * Setter $onSystem
     * @param {boolean} value
     */
	public set $onSystem(value: boolean) {
		this.onSystem = value;
	}

    /**
     * Getter $storeProducts
     * @return {StoreProduct}
     */
	public get $storeProducts(): StoreProduct {
		return this.storeProducts;
	}

    /**
     * Setter $storeProducts
     * @param {StoreProduct} value
     */
	public set $storeProducts(value: StoreProduct) {
		this.storeProducts = value;
	}

    /**
     * Getter $owner
     * @return {User}
     */
	public get $owner(): User {
		return this.owner;
	}

    /**
     * Setter $owner
     * @param {User} value
     */
	public set $owner(value: User) {
		this.owner = value;
	}

    /**
     * Getter $collaborators
     * @return {User[]}
     */
	public get $collaborators(): User[] {
		return this.collaborators;
	}

    /**
     * Setter $collaborators
     * @param {User[]} value
     */
	public set $collaborators(value: User[]) {
		this.collaborators = value;
	}

    /**
     * Getter $operations
     * @return {Operation[]}
     */
	public get $operations(): Operation[] {
		return this.operations;
	}

    /**
     * Setter $operations
     * @param {Operation[]} value
     */
	public set $operations(value: Operation[]) {
		this.operations = value;
	}

    /**
     * Getter $name
     * @return {string}
     */
	public get $name(): string {
		return this.name;
	}

    /**
     * Setter $name
     * @param {string} value
     */
	public set $name(value: string) {
		this.name = value;
	}

    /**
     * Getter $id
     * @return {number}
     */
	public get $id(): number {
		return this.id;
	}

    /**
     * Setter $id
     * @param {number} value
     */
	public set $id(value: number) {
		this.id = value;
	}
    constructor () {

    }
    setData(Data): void{
      this.id = Data.id;
      this.name = Data.userName;
      this.type = Data.type;
      this.location = Data.location;
      this.onSystem = Data.onSystem;
      this.storeProducts = Data.StoreProducts;
      this.owner = Data.owner;
      this.collaborators = Data.collaborators;
      this.operations = Data.operations;
    }
  }
  
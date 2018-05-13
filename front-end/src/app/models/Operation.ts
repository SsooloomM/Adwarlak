import { StoreProduct } from './StoreProduct';
import { User } from './user';
import { Store } from "./store";

export class Operation{
    private id: number;
	private user: User;
	private store: Store;
	private operation: string;
	private before: StoreProduct;
    private after: StoreProduct;
    

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

    /**
     * Getter $user
     * @return {User}
     */
	public get $user(): User {
		return this.user;
	}

    /**
     * Setter $user
     * @param {User} value
     */
	public set $user(value: User) {
		this.user = value;
	}

    /**
     * Getter $store
     * @return {Store}
     */
	public get $store(): Store {
		return this.store;
	}

    /**
     * Setter $store
     * @param {Store} value
     */
	public set $store(value: Store) {
		this.store = value;
	}

    /**
     * Getter $before
     * @return {StoreProduct}
     */
	public get $before(): StoreProduct {
		return this.before;
	}

    /**
     * Setter $before
     * @param {StoreProduct} value
     */
	public set $before(value: StoreProduct) {
		this.before = value;
	}

    /**
     * Getter $operation
     * @return {string}
     */
	public get $operation(): string {
		return this.operation;
	}

    /**
     * Setter $operation
     * @param {string} value
     */
	public set $operation(value: string) {
		this.operation = value;
	}

    /**
     * Getter $after
     * @return {StoreProduct}
     */
	public get $after(): StoreProduct {
		return this.after;
	}

    /**
     * Setter $after
     * @param {StoreProduct} value
     */
	public set $after(value: StoreProduct) {
		this.after = value;
	}
    constructor(){
    }

    setData(Data): void{
        this.id = Data.id;
        this.user = Data.user;
        this.store = Data.store;
        this.operation = Data.operation;
        this.before = Data.before;
        this.after = Data.after;
    }
}
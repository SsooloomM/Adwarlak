import { Product } from './product';
import { Store } from './store';

export class StoreProduct {
    private product: Product;
	private store: Store;
	private id: number;
	private views: number;
	private solds: number;
	private available: number;
    private price: number;

    constructor(){

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

    /**
     * Getter $views
     * @return {number}
     */
	public get $views(): number {
		return this.views;
	}

    /**
     * Setter $views
     * @param {number} value
     */
	public set $views(value: number) {
		this.views = value;
	}

    /**
     * Getter $solds
     * @return {number}
     */
	public get $solds(): number {
		return this.solds;
	}

    /**
     * Setter $solds
     * @param {number} value
     */
	public set $solds(value: number) {
		this.solds = value;
	}

    /**
     * Getter $available
     * @return {number}
     */
	public get $available(): number {
		return this.available;
	}

    /**
     * Setter $available
     * @param {number} value
     */
	public set $available(value: number) {
		this.available = value;
	}

    /**
     * Getter $price
     * @return {number}
     */
	public get $price(): number {
		return this.price;
	}

    /**
     * Setter $price
     * @param {number} value
     */
	public set $price(value: number) {
		this.price = value;
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
     * Getter $product
     * @return {Product}
     */
	public get $product(): Product {
		return this.product;
	}

    /**
     * Setter $product
     * @param {Product} value
     */
	public set $product(value: Product) {
		this.product = value;
	}
    setData(Data): void{
        this.id = Data.id;
        this.views = Data.views;
        this.solds = Data.solds;
        this.price = Data.price;
        this.available = Data.available;
        this.store = Data.store;
        this.product = Data.product;
    }
}
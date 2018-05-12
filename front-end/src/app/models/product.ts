import { Brand } from './Brand';
import { StoreProduct } from "./StoreProduct";

export class Product{
    private id: number;

    /**
     * Getter $upper
     * @return {number}
     */
	public get $upper(): number {
		return this.upper;
	}

    /**
     * Setter $upper
     * @param {number} value
     */
	public set $upper(value: number) {
		this.upper = value;
	}

    /**
     * Getter $category
     * @return {string}
     */
	public get $category(): string {
		return this.category;
	}

    /**
     * Setter $category
     * @param {string} value
     */
	public set $category(value: string) {
		this.category = value;
	}

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
     * Getter $onsystem
     * @return {boolean}
     */
	public get $onsystem(): boolean {
		return this.onsystem;
	}

    /**
     * Setter $onsystem
     * @param {boolean} value
     */
	public set $onsystem(value: boolean) {
		this.onsystem = value;
	}

    /**
     * Getter $brand
     * @return {Brand}
     */
	public get $brand(): Brand {
		return this.brand;
	}

    /**
     * Setter $brand
     * @param {Brand} value
     */
	public set $brand(value: Brand) {
		this.brand = value;
	}

    /**
     * Getter $stores
     * @return {StoreProduct[]}
     */
	public get $stores(): StoreProduct[] {
		return this.stores;
	}

    /**
     * Setter $stores
     * @param {StoreProduct[]} value
     */
	public set $stores(value: StoreProduct[]) {
		this.stores = value;
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
	private name: string;

    /**
     * Getter $lower
     * @return {number}
     */
	public get $lower(): number {
		return this.lower;
	}

    /**
     * Setter $lower
     * @param {number} value
     */
	public set $lower(value: number) {
		this.lower = value;
	}
	private lower: number;
	private upper: number;
	private category: string;
	private type: string;   // online or offline
	private onsystem: boolean;
	private brand: Brand;
    private stores: StoreProduct[];
    
    constructor(){

    }
    setData(Data): void{
        this.id = Data.id;
        this.name = Data.name;
        this.lower = Data.lower;
        this.upper = Data.upper;
        this.category = Data.category;
        this.type = Data.type;
        this.onsystem = Data.onsystem;
        this.brand = Data.brand;
        this.stores = Data.stores;
    }
    
}
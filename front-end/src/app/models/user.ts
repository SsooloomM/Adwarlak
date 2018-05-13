import { Operation } from './Operation';
import { Store } from "./store";

export class User {
    private id: number;
    private name: string;
    private password: string;
    private stores: Store[];
    private otherStores: Store[];
    private operations: Operation[];


    constructor () {

    }
    setData(Data): void{
        this.id = Data.id;
        this.name = Data.userName;
        this.password = Data.password;
    }

    toJSON(): object{
        let data = {
            userName: this.name,
            password: this.password
        };

        return data;
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
     * Getter $stores
     * @return {Store[]}
     */
	public get $stores(): Store[] {
		return this.stores;
	}

    /**
     * Setter $stores
     * @param {Store[]} value
     */
	public set $stores(value: Store[]) {
		this.stores = value;
	}

    /**
     * Getter $otherStores
     * @return {Store[]}
     */
	public get $otherStores(): Store[] {
		return this.otherStores;
	}

    /**
     * Setter $otherStores
     * @param {Store[]} value
     */
	public set $otherStores(value: Store[]) {
		this.otherStores = value;
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
     * Getter $password
     * @return {string}
     */
	public get $password(): string {
		return this.password;
	}

    /**
     * Setter $password
     * @param {string} value
     */
	public set $password(value: string) {
		this.password = value;
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
}

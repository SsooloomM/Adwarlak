export class Brand{
    private id: number;
	private name: string;
    private category: string;
    

    /**
     * Getter $id
     * @return {number}
     */
	public get $id(): number {
		return this.id;
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
     * Setter $id
     * @param {number} value
     */
	public set $id(value: number) {
		this.id = value;
	}
    constructor(){
    }

    setData(Data): void {
        this.id = Data.id;
        this.name = Data.name;
        this.category = Data.category;
    }
}
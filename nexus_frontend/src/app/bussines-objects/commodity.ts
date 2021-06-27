import { User } from "./user";

export class Commodity{
    productName:string="";
    productAmount:number=0;
    dateOfAdmission:Date=new Date();
    modificationDate:Date=new Date();
    user:string="";
    modified_by:string="";
}
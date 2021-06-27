import { Injectable } from '@angular/core';
import { Commodity } from '../bussines-objects/commodity';
import 'rxjs';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';
import { User } from '../bussines-objects/user';
import { Position } from '../bussines-objects/position';

@Injectable({
  providedIn: 'root'
})
export class NexusServicesService {
  url="http://localhost:8080/";
  constructor(private http:HttpClient) { }

  //GET Services
  getCommodities():Observable<Commodity[]>{
    return this.http.get<Commodity[]>(this.url+"/commodity/commodities");
  }

  getUsers():Observable<User[]>{
    return this.http.get<User[]>(this.url+"/user/users");
  }

  getPositions():Observable<Position[]>{
    return this.http.get<Position[]>(this.url+"/position/positions");
  }

  //PUT Services

  putCommodity(commodity:Commodity):Observable<Commodity>{
    return this.http.put<Commodity>(this.url+"/commodity",commodity);
  }

  //POST Services
  
  postUser(user:User){
    return this.http.post<Commodity>(this.url+"/user",user);
  }
  postPosition(position:Position){
    return this.http.post<Commodity>(this.url+"/position",position);
  }

  postCommodity(commodity:Commodity){
    return this.http.post(this.url+"/commodity",commodity);
  }

  //DELETE Services

  deleteUser(name:string){
    return this.http.delete(this.url+"/user" + "/" + name);
  }

  deletePosition(name:string){
    return this.http.delete(this.url+"/position" + "/" + name);
  }

  deleteCommodity(name:string){
    return this.http.delete(this.url+"/commodity" + "/" + name);
  }
}

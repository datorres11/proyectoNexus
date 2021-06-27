import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/bussines-objects/user';
import { NexusServicesService } from 'src/app/api-services/nexus-services.service';
import { Position } from 'src/app/bussines-objects/position';
import { FormControl, FormGroup, Validators,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {
  title = 'ProyectoAngular';
  userForm:User;
  users:User[]=[];
  positions:Position[]=[];

  form: FormGroup;

  constructor(private nexusServicesService:NexusServicesService,
    private formBuilder:FormBuilder) {
    this.userForm=new User();

    this.form=this.formBuilder.group({
      userName:['',[Validators.required]],
      userAge:['',[Validators.required]],
      position:['',[Validators.required]]
     })
     this.form.valueChanges.subscribe(value=>{
      console.log(value)
    })
   }

  ngOnInit(): void {
    this.nexusServicesService.getPositions().subscribe(
      (list: Position[])=>{this.positions=list
      })
    this.getUsers();
  }

  getUsers(){
    this.nexusServicesService.getUsers().subscribe(
      (list: User[])=>{this.users=list
      }
    )
  }

  saveUser(){
    this.setValues()
    this.nexusServicesService.postUser(this.userForm).subscribe(element=>{console.log(element)});
  }

  deleteUser(user:User){
    this.nexusServicesService.deleteUser(user.userName).subscribe(element=>{console.log(element)});
  }

  setValues(){
    this.userForm.userName=this.form.value.userName
    this.userForm.userAge=this.form.value.userAge
    this.userForm.position=this.form.value.position
  }
}

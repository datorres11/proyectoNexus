import { Component, OnInit } from '@angular/core';
import { Position } from 'src/app/bussines-objects/position';
import { NexusServicesService } from 'src/app/api-services/nexus-services.service';
import { FormControl, FormGroup, Validators,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-admin-position',
  templateUrl: './admin-position.component.html',
  styleUrls: ['./admin-position.component.css']
})
export class AdminPositionComponent implements OnInit {
  title = 'ProyectoAngular';
  positionForm:Position;
  positions:Position[]=[];
  form:FormGroup

  constructor(private nexusServicesService:NexusServicesService,
    private formBuilder:FormBuilder) {
    this.positionForm=new Position();
    this.form=this.formBuilder.group({
      positionName:['',[Validators.required]]
     })
     this.form.valueChanges.subscribe(value=>{
      console.log(value)
    })
   }

  ngOnInit(): void {
    this.nexusServicesService.getPositions().subscribe(
      (list: Position[])=>{this.positions=list
      }
    )
  }

  savePosition(){
    this.positionForm=this.form.value.positionName
    this.nexusServicesService.postPosition(this.positionForm).subscribe(element=>{console.log(element)})
  }

  deletePosition(position:Position){
    this.nexusServicesService.deletePosition(position.positionName).subscribe(element=>{console.log(element)})
  }
}

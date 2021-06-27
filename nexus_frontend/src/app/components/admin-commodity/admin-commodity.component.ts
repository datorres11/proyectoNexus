import { Component, OnInit } from '@angular/core';
import {Commodity} from '../../bussines-objects/commodity';
import { NexusServicesService } from '../../api-services/nexus-services.service';
import { User } from 'src/app/bussines-objects/user';
import { FormControl, FormGroup, Validators,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-admin-commodity',
  templateUrl: './admin-commodity.component.html',
  styleUrls: ['./admin-commodity.component.css']
})
export class AdminCommodityComponent implements OnInit {
  [x: string]: any;

  commodityTitle = 'Add Commodity';
  commodityForm:Commodity;
  commodities:Commodity[]=[];
  users:User[]=[];
  userSelected:string="";
  filterName="";
  edit=false;
  editAble=false;
  deleteAble=false;
  maxDate:Date;
  admissionDate:Date;
  deleteDisabled=false;
  form: FormGroup;
  formEdit: FormGroup;

  

  constructor(private nexusServicesService:NexusServicesService,
    private formBuilder:FormBuilder) {
    this.commodityForm=new Commodity();
    this.maxDate=new Date();
    this.admissionDate=new Date();

    this.form=this.formBuilder.group({
      user:['',[Validators.required]],
      productName:['',[Validators.required]],
      productAmount:['',[Validators.required]],
      dateOfAdmission:['',[Validators.required]]
     })
     this.form.valueChanges.subscribe(value=>{
      console.log(value)
    })

    this.formEdit=this.formBuilder.group({
      user:['',[Validators.required]],
      productName:['',[Validators.required]],
      userSelected:['',[Validators.required]],
      productAmount:['',[Validators.required]],
      modificationDate:['',[Validators.required]]
     })
     this.formEdit.valueChanges.subscribe((valueEdit: any)=>{
      console.log(valueEdit)
    })
   }

  ngOnInit(): void {
    this.nexusServicesService.getUsers().subscribe(
      (list: User[])=>{this.users=list
      }
    )
    this.getCommodities()
  }

  getCommodities(){
    this.nexusServicesService.getCommodities().subscribe(
      (list: Commodity[])=>{this.commodities=list
      }
    )
  }

  saveCommodity(){
    if(this.edit==true){
      this.setValue()
      this.nexusServicesService.putCommodity(this.commodityForm)
                               .subscribe(element=>{console.log(element)
                                                    this.getCommodities()})
      this.cancelEdit();
      alert("Update successfully")
    }else{
      if(this.validarProducto()){
        alert("The product name is already exists")
        this.cancelEdit();
      }else{
        this.setValue()
        this.nexusServicesService.postCommodity(this.commodityForm)
                                .subscribe(element=>{ console.log(element); 
                                                      this.getCommodities()})
        this.cancelEdit();
        alert("create successfully")
      }
    }
    this.commodityTitle="Add Commodity"
    this.deleteDisabled=true
  }

  deleteCommodity(commodity:Commodity){
    if(this.userSelected == commodity.user){
      this.nexusServicesService.deleteCommodity(commodity.productName).subscribe(element=>{console.log(element)
                                                                                           this.getCommodities()})
      this.cancelEdit();
      alert("delete successfully")
    }else{
      alert("permission denied")
    }
  }

  editCommodity(commodity:Commodity){
    this.commodityTitle="Edit Commodity"
    this.edit=true;
    this.deleteDisabled=false
    this.lastUpdate=new Date(commodity.modificationDate);
    this.admissionDate=commodity.dateOfAdmission;
    this.formEdit.setValue({user:commodity.user,productName:commodity.productName,productAmount:commodity.productAmount,userSelected:this.userSelected,modificationDate:""})

  }

  actionsAble(){
    this.editAble=true
    this.deleteDisabled=true
    this.userSelected=this.form.value.user;
  }

  cancelEdit(){
    this.edit=false;
    this.editAble=false
    this.deleteDisabled=false
    this.commodityTitle="Add Commodity"
    this.form.reset();
  }

  setValue(){
    if(this.edit==true){
      this.commodityForm.productName=this.formEdit.value.productName
      this.commodityForm.productAmount=this.formEdit.value.productAmount
      this.commodityForm.dateOfAdmission=new Date(this.formEdit.value.dateOfAdmission)
      this.commodityForm.user=this.formEdit.value.user
      this.commodityForm.modified_by=this.formEdit.value.userSelected
      this.commodityForm.modificationDate=new Date(this.formEdit.value.modificationDate)
      this.commodityForm.modificationDate.setDate(this.commodityForm.modificationDate.getDate()+1)
    }else{
    this.commodityForm.productName=this.form.value.productName
    this.commodityForm.productAmount=this.form.value.productAmount
    this.commodityForm.dateOfAdmission=new Date(this.form.value.dateOfAdmission)
    this.commodityForm.user=this.form.value.user
    }
  }

  validarProducto():boolean{
    let resp=false
    this.commodities.forEach(commodity=>{
      if(this.form.value.productName==commodity.productName){
        resp= true;
        return;
      }
    })
    return resp;
  }
}

import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, arg: any): any {
    const result=[];
    for(const comodity of value){
      if(comodity.productName.toLowerCase().indexOf(arg.toLowerCase())>-1){
        result.push(comodity);
      }
    }
    return result;
  }

}
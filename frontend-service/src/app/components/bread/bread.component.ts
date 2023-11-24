import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {CommonModule, getLocaleId} from '@angular/common';
import {BreadService} from "../../services/bread/bread.service";
import {Bread} from "../../models/Bread";
import {MatTableDataSource, MatTableModule} from "@angular/material/table";
import {MatSort, MatSortModule, Sort} from "@angular/material/sort";
import {LiveAnnouncer} from "@angular/cdk/a11y";
import { FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
@Component({
  selector: 'app-bread',
  standalone: true,
  imports: [CommonModule, MatSortModule, MatTableModule, ReactiveFormsModule],
  templateUrl: './bread.component.html',
  styleUrl: './bread.component.css'
})

export class BreadComponent implements OnInit, AfterViewInit{
  breads: Array<Bread> = []
  orders: Map<String,Number> = new Map()
  sortedData = this.breads

  id! :number;
  value: any;

  orderForm = new FormGroup({

    MON: new FormControl(),
    TUE: new FormControl(),
    WEN: new FormControl(),
    THU: new FormControl(),
    FRI: new FormControl(),
    SAT: new FormControl(),

  })





  displayedColumns: string[] = ['picture', 'name', 'orders','articleNumber', 'weight'];
  dataSource = new MatTableDataSource(this.breads);

  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(LiveAnnouncer)liveAnnouncer!: LiveAnnouncer




  constructor(private breadService: BreadService) {



  }


  get monday(){
    return this.orderForm.controls.MON
  }
  get thuesday(){
    return this.orderForm.controls.TUE
  }
  get wendsday(){
    return this.orderForm.controls.WEN
  }
  get thursday(){
    return this.orderForm.controls.THU
  }
  get friday(){
    return this.orderForm.controls.FRI
  }
  get saturday(){
    return this.orderForm.controls.SAT
  }

  ngOnInit(): void {
    this.breadService
        .getAllBread()
        .subscribe(dataFromServer => {
            console.log("Getting data from server " +JSON.stringify(dataFromServer))
            this.dataSource.data = dataFromServer;

        })
  }

  updateBread(bread:Bread){
    this.value = this.orderForm.value
    bread.orders = this.value;
    console.log("Chleb do aktualizacji " + JSON.stringify(bread))
    this.breadService.updateOrders(bread).subscribe();
    return;
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;

  }
  announceSortChange(sortState: Sort) {
    // This example uses English messages. If yo{ur application supports
    // multiple language, you would internationalize these strings.
    // Furthermore, you can customize the message to add additional
    // details about the values being sorted.
    if (sortState.direction) {

      this.liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this.liveAnnouncer.announce('Sorting cleared');
    }
  }
  sortData(sort: Sort) {
    const data = this.breads.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData = data;
      return;
    }

    this.sortedData = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'name':
          return compare(a.name, b.name, isAsc);
        case 'artikel':
          return compare(a.articleNumber, b.articleNumber, isAsc);
        case 'weight':
          return compare(a.weight, b.weight, isAsc);
        default:
          return 0;
      }
    });
  }
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);

}





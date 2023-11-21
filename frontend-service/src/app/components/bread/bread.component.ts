import {AfterViewInit, Component, numberAttribute, OnInit, ViewChild} from '@angular/core';
import { CommonModule } from '@angular/common';
import {BreadService} from "../../services/bread/bread.service";
import {Bread} from "../../models/Bread";
import {MatTableDataSource, MatTableModule} from "@angular/material/table";
import {MatSort, MatSortModule, Sort} from "@angular/material/sort";
import {LiveAnnouncer} from "@angular/cdk/a11y";


@Component({
  selector: 'app-bread',
  standalone: true,
  imports: [CommonModule, MatSortModule,MatTableModule ],
  templateUrl: './bread.component.html',
  styleUrl: './bread.component.css'
})

export class BreadComponent implements OnInit, AfterViewInit{
  breads: Array<Bread> = []

  sortedData = this.breads

  displayedColumns: string[] = ['picture', 'name', 'articleNumber', 'weight'];
  dataSource = new MatTableDataSource(this.breads);

  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(LiveAnnouncer)liveAnnouncer!: LiveAnnouncer


  constructor(private breadService: BreadService) {
  }

  ngOnInit(): void {
    this.breadService
        .getAllBread()
        .subscribe(value => {
            console.log("Getting breads from server " +JSON.stringify(value))
            this.dataSource.data = value
        })
  }

  ngAfterViewInit(): void {
    this.dataSource.sort = this.sort;

  }
  announceSortChange(sortState: Sort) {
    // This example uses English messages. If your application supports
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




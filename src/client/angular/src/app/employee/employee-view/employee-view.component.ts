import { Component, OnInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import {MatPaginator, MatTableDataSource, MatSort} from '@angular/material';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-view',
  templateUrl: './employee-view.component.html',
  styleUrls: ['./employee-view.component.css']
})
export class EmployeeViewComponent implements OnInit {

  displayedColumns = ['id', 'firstName', 'lastName', 'salary'];
  dataSource: MatTableDataSource<Employee> = new MatTableDataSource<Employee>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  employees: Employee[] = [];
  resultsLength = this.employees.length;

  constructor(private empService: EmployeeService, private changeDetectorRefs: ChangeDetectorRef) { }

  ngOnInit() {
    this.empService.getAllEmployees().subscribe((emp)=>{
      this.employees = emp;
      console.log(this.employees);
      this.dataSource.data = this.employees;
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
    this.empService.updateRequest$.subscribe(emp =>{
      if(emp){
        this.employees = this.employees.concat(emp);
        this.dataSource.data = this.employees;
        this.dataSource.sort = this.sort;
        this.resultsLength = this.employees.length
      }
    })
  }

}

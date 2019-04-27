import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Employee } from './employee';

const BASE_URL: string="http://localhost:8070/employee";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  updateRequest: BehaviorSubject<Employee> = new BehaviorSubject({});

  public readonly updateRequest$: Observable<Employee> = this.updateRequest.asObservable();

  constructor(private http: HttpClient) { 

  }
  public getAllEmployees():Observable<Employee[]>{
      return this.http.get(BASE_URL) as Observable<Employee[]>;
  }

  public saveEmployee(emp: Employee):Observable<Employee>{
    return this.http.post(BASE_URL, emp) as Observable<Employee>;
  }
  public updateEmployeeTable(emp: Employee){
    this.updateRequest.next(emp);
  }
}

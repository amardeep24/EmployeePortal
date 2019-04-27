import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { EmployeeService } from './../employee.service';
import { Employee } from './../employee';

@Component({
  selector: 'app-employee-register',
  templateUrl: './employee-register.component.html',
  styleUrls: ['./employee-register.component.css']
})
export class EmployeeRegisterComponent implements OnInit {

  employeeForm: FormGroup;
  emp: Employee;
  
  constructor(private empService: EmployeeService) { }

  ngOnInit() {
    this.employeeForm = new FormGroup({
      firstName: new FormControl(),
      lastName: new FormControl(),
      salary: new FormControl()
    });
  }
  saveEmployee(){
    let emp: Employee = {firstName: this.employeeForm.get("firstName").value, lastName: this.employeeForm.get("lastName").value, salary: this.employeeForm.get("salary").value};
    this.empService.saveEmployee(emp).subscribe(emp =>{
      this.emp = emp;
      this.empService.updateEmployeeTable(emp);
    });
   
  }
  

}

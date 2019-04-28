import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeRegisterComponent } from './employee-register/employee-register.component';
import { EmployeeViewComponent } from './employee-view/employee-view.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatInputModule, MatTableModule, MatPaginatorModule, MatSortModule, MatProgressSpinnerModule, MatIconModule, MatFormFieldModule, MatToolbarModule, MatButtonModule, MatStepperModule, MatDialogModule } from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'


@NgModule({
  declarations: [EmployeeRegisterComponent, EmployeeViewComponent],
  imports: [
    CommonModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatIconModule,
    MatProgressSpinnerModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatStepperModule,
    MatDialogModule
  ],
  exports: [EmployeeRegisterComponent, EmployeeViewComponent]
})
export class EmployeeModule { }

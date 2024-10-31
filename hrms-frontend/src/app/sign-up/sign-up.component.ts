import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/router';
import { SignUpService } from './sign-up.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './sign-up.component.html',
  styleUrl: './sign-up.component.css'
})
export class SignUpComponent {

  signUpForm: FormGroup;

  constructor(private signupService: SignUpService, private fb: FormBuilder) {

    this.signUpForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required]

    })

  }


  signUp() {

    if (this.signUpForm.invalid) {
      return;
    }

    firstValueFrom(this.signupService.createUser(this.signUpForm.value))
      .then(res => {
        console.log(res);
        alert(res.message);
      })
      .catch(err => {
        console.log(err);
        alert(err.error.message);
      })

  }



}



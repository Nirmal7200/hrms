import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { ApiResponse, User } from './models';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {


  signUpBaseUrl = "http://localhost:8080";

  constructor(private httpclient: HttpClient) { }



  createUser(signUpRequest: User): Observable<ApiResponse> {
    const url = `${this.signUpBaseUrl}/api/create-user`;
    return this.httpclient.post<ApiResponse>(url, signUpRequest);
  }


}

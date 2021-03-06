import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Aluno } from './aluno.model';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  baseurl = "http://localhost:8080/sistema-academico/alunos";

  constructor(private httpClient : HttpClient, private _snackBar: MatSnackBar) { }

  openSnackBar(mensagem : string) {
    this._snackBar.open(mensagem, 'X', {
      duration: 2000,
      horizontalPosition: "center",
      verticalPosition: "top",
    });
  }

  getAlunoList(): Observable<any>{
    return this.httpClient.get(`${this.baseurl}`);
  }

  getAluno(id : number) : Observable<any>{
    return this.httpClient.get(`${this.baseurl}/${id}`);
  }

  createAluno(aluno: Object): Observable<Object>{
    return this.httpClient.post(`${this.baseurl}`, aluno);
  }

  updateAluno(id: number, value: any) : Observable<Object>{
    return this.httpClient.put(`${this.baseurl}/${id}`, value);
  }

  deleteAluno(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseurl}/${id}`, {responseType: 'text'});
  }
}

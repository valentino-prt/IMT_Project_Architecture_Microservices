import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {Trainer} from "./user-detail/user-detail.component";

@Injectable({
  providedIn: 'root'
})
export class TrainerService {
  transactionStatus: boolean = Boolean(0);


  constructor(private http: HttpClient) {
  }

  getTrainers(): Observable<Trainer[]> {
    return this.getRequest<Trainer[]>('http://localhost:8080/dresseurs');
  }

  addMoney(price: number): Observable<Trainer> {
    return this.putRequest(`http://localhost:8080/addGold?id=1&amount=${price}`);
  }

  subMoney(price: number): Observable<Trainer> {
    return this.putRequest(`http://localhost:8080/removeGold?id=1&amount=${price}`);
  }

  addXP(xp: number): Observable<Trainer> {
    return this.putRequest(`http://localhost:8080/addXp?id=1&amount=${xp}`);

  }

  addTrainer(trainer: Trainer) {
    return this.postRequest(`http://localhost:8080/addDresseur?name=${trainer.name}&gold=${trainer.gold}&xp=${trainer.xp}`);
  }

  private putRequest(url: string) {
    return this.http.put<any>(url, {}).pipe(
      tap((response) => {
        console.log(response.message);
        this.transactionStatus = response.status === "success";
      }),
      catchError((error) => {
        console.error(error);
        return of(error);
      })
    )
  }

  private postRequest(url: string) {
    return this.http.post<any>(url, {}).pipe(
      tap((response) => {
        console.log(response.message);
      }),
      catchError((error) => {
        console.error(error);
        return of(error);
      })
    )
  }

  private getRequest<T>(url: string): Observable<T> {
    return this.http.get<T>(url).pipe(
      catchError((error) => {
        console.log(error);
        return of([] as T);
      })
    );
  }

}



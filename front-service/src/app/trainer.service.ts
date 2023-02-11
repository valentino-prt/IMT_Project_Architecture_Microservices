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

  getData<T>(url: string): Observable<T> {
    return this.http.get<T>(url).pipe(
      tap((response) => console.table(response)),
      catchError((error) => {
        console.log(error);
        return of([] as T);
      })
    );
  }

  getTrainers(): Observable<Trainer[]> {
    return this.getData<Trainer[]>('http://localhost:8080/dresseurs');
  }

  addMoney(price: number): Observable<Trainer> {
    //Request is not working
    return this.http.put<any>(`http://localhost:8080/addGold?id=1&amount=${price}`, {observe: 'response'}).pipe(
      tap((response) => {
        if (response.status === 200) {
          console.log('Money was successfully added.');
        } else {
          console.error('An error occurred while adding Money.');
        }
      }),
      catchError((error) => {
        console.error(error);
        return of(error);
      })
    )

  }

  subMoney(price: number): Observable<Trainer> {
    //Request is not working
    return this.putRequest(`http://localhost:8080/removeGold?id=1&amount=${price}`);
  }

  addXP(xp: number): Observable<Trainer> {
    //Request is not working
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

}



import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {Trainer} from "./user-detail/user-detail.component";

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

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

  getTrainer(): Observable<Trainer> {
    return this.getData<Trainer>('http://localhost:8080/dresseurs');
  }

  addMoney(money: number): Observable<Trainer> {
    //Request is not working
    return this.http.post<Trainer>('http://localhost:8080/add_gold', money);
  }

  addTrainer(trainerList: Trainer[]): Observable<Trainer> {
    return this.http.post<Trainer>('http://localhost:8080/add_dresseurs', trainerList[0]);
  }

  subMoney(money: number): Observable<Trainer> {
    //Request is not working
    return this.http.post<Trainer>('http://localhost:8080/sub_gold', money);
  }

}



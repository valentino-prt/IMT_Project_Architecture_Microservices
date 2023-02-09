import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {PokemonForSale} from "./pokemon/pokemon.component";

@Injectable({
  providedIn: 'root'
})
export class MarketService {
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

  getPokemonsForSell(): Observable<PokemonForSale[]> {
    return this.getData<PokemonForSale[]>(`http://localhost:8084/list_egg`);
  }

  removePokemon(id: number) {
    // TODO: change url
    return this.http.delete(``, {observe: 'response'}).pipe(
      tap((response) => {
        if (response.status === 200) {
          console.log('The Pokemon was successfully deleted.');
        } else {
          console.error('An error occurred while deleting the Pokemon.');
        }
      }),
      catchError((error) => {
        console.error(error);
        return of(error);
      })
    );


  }
}

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

  getPokemonsForSell(): Observable<PokemonForSale[]> {
    return this.getRequest<PokemonForSale[]>(`http://localhost:8084/getAllEggToBuy`);
  }

  removePokemon(id: number) {
    return this.deleteRequest(`http://localhost:8084/removeEgg?id=${id}`);
  }

  private getRequest<T>(url: string): Observable<T> {
    return this.http.get<T>(url).pipe(
      catchError((error) => {
        console.log(error);
        return of([] as T);
      })
    );
  }

  private deleteRequest(url: string) {
    return this.http.delete<any>(url, {}).pipe(
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

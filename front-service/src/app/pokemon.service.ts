import {Injectable} from '@angular/core';
import {Pokemon} from "./pokemon/pokemon.component";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {Egg} from "./egg/egg.component";

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

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

  getPokemonList(): Observable<Pokemon[]> {
    return this.getData<Pokemon[]>('http://localhost:8081/pokemons');
  }

  getEggList(): Observable<Egg[]> {
    return this.getData<Egg[]>('http://localhost:8082/allEggs');
  }

  removePokemon(id: number) {
    return this.http.delete(`http://localhost:8081/delete_pokemon?id=${id}`, {observe: 'response'}).pipe(
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

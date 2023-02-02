import {Injectable} from '@angular/core';
import {Pokemon} from "./pokemon/pokemon.component";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) {
  }

  getPokemonList(): Observable<Pokemon[]> {
    return this.http.get<Pokemon[]>('http://localhost:4000/pokemons').pipe(
      tap((response) => console.table(response)),
      catchError((error) => {
        console.log(error);
        return of([]);
      })
    )
  }


}

import {Injectable} from '@angular/core';
import {Egg, MyPokemon} from "./pokemon/pokemon.component";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
import {error} from "@angular/compiler-cli/src/transformers/util";

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

  getPokemonList(): Observable<MyPokemon[]> {
    return this.getData<MyPokemon[]>('http://localhost:8081/pokemons');
  }

  getEggListInv(): Observable<Egg[]> {
    return this.getData<Egg[]>('http://localhost:8081/eggs');
  }

  getEggList(): Observable<Egg[]> {
    return this.getData<Egg[]>('http://localhost:8082/allEggs');
  }

  removePokemon(id: number) {
    return this.http.delete(`http://localhost:8081/deletePokemon?id=${id}`, {observe: 'response'}).pipe(
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

  removeEgg(id: number) {
    return this.http.delete(`http://localhost:8081/deleteEgg?id=${id}`, {observe: 'response'}).pipe(
      tap((response) => {
        if (response.status === 200) {
          console.log('The Egg was successfully deleted.');
        } else {
          console.error('An error occurred while deleting the Egg.');
        }
      }),
      catchError((error) => {
        console.error(error);
        return of(error);
      })
    );
  }

  hatch(egg: Egg) {
    return this.http.post(`http://localhost:8082/addEgg?name=${egg.name}&no=${egg.no}&hatchingTime=${egg.hatchingTime}`, {observe: 'response'}).pipe(
      tap((response) => {
        console.log(response);
      }),
      catchError((error) => {
        console.error(error);
        return of(error);
      })
    );

  }

  addEgg(egg: Egg) {
    return this.http.post<any>(`http://localhost:8081/addEgg?name=${egg.name}&no=${egg.no}&hatchingTime=${egg.hatchingTime}`, {observe: 'response'}).pipe(
      tap((response) => {
        if (response.status === 200) {
          console.log('Egg was successfully added.');
        } else {
          console.error('An error occurred while adding egg.');
        }
      }),
      catchError((error) => {
        console.error(error);
        return of(error);
      })
    );
  }


}

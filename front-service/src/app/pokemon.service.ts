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

  removeEgg(id: number) {
    return this.http.delete(`http://localhost:8081/delete_egg?id=${id}`, {observe: 'response'}).pipe(
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
    return this.http.post(`http://localhost:8082/egg?name=${egg.name}&No=${egg.no}&hatchingTime=${egg.hatchingTime}`, {observe: 'response'}).pipe(
      tap((response) => {
        console.log(response); //je n'arrive pas à accéder au properties de l'objet response
        //this.http.delete(`http://localhost:8081/delete_egg?id=${response.valueOf()}`)
        /*if (response === 200) {
          console.log('Egg was successfully add to hatching service.');
        } else {
          console.error('An error occurred while add egg to hatching service.');
        }*/
      }),
      catchError((error) => {
        console.error(error);
        return of(error);
      })
    );

  }


}

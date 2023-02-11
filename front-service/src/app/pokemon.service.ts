import {Injectable} from '@angular/core';
import {Egg, MyPokemon} from "./pokemon/pokemon.component";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PokemonService {

  constructor(private http: HttpClient) {
  }

  getPokemonList(): Observable<MyPokemon[]> {
    return this.getRequest<MyPokemon[]>('http://localhost:8081/pokemons');
  }

  getEggListInv(): Observable<Egg[]> {
    return this.getRequest<Egg[]>('http://localhost:8081/eggs');
  }

  getEggList(): Observable<Egg[]> {
    return this.getRequest<Egg[]>('http://localhost:8082/allEggs');
  }

  removePokemon(id: number) {
    return this.deleteRequest(`http://localhost:8081/deletePokemon?id=${id}`);
  }

  removeEgg(id: number) {
    return this.deleteRequest(`http://localhost:8081/deleteEgg?id=${id}`);
  }

  hatch(egg: Egg) {
    return this.postRequest(`http://localhost:8082/addEgg?name=${egg.name}&no=${egg.no}&hatchingTime=${egg.hatchingTime}`)
  }

  addEgg(egg: Egg) {
    return this.postRequest(`http://localhost:8081/addEgg?name=${egg.name}&no=${egg.no}&hatchingTime=${egg.hatchingTime}`)
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

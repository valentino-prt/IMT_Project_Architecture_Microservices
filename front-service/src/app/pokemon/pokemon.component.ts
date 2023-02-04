import {Component, OnInit} from '@angular/core';
import {PokemonService} from "../pokemon.service";


@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})

export class PokemonComponent implements OnInit {
  pokemonList: Pokemon[] = [];

  constructor(private pokemonService: PokemonService) {
  }

  ngOnInit() {
    setInterval(() => {
      this.pokemonService.getPokemonList().subscribe(pokemonList => {
        this.pokemonList = pokemonList;
        this.pokemonList = this.pokemonList.map(pokemon => {
          return {
            ...pokemon, picture: `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${pokemon.no}.png`
          }
        })
      });
    }, 1000)

  }


  public removePokemon(pokemon: Pokemon) {
    this.pokemonService.removePokemon(pokemon.id).subscribe(() => {
      this.pokemonList = this.pokemonList.filter(p => p.id !== pokemon.id);
    })
  }
}

export class Pokemon {
  id: number;
  name: string;
  no: string;
  level: number;

  picture: string;

  constructor(id: number, name: string, no: string, level: number) {
    this.id = id;
    this.name = name;
    this.no = no;
    this.level = level;
    this.picture = `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${this.no}.png`
  }
}

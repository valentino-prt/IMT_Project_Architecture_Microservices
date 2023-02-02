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
    this.pokemonService.getPokemonList().subscribe(pokemonList => {
      this.pokemonList = pokemonList;
      this.pokemonList = this.pokemonList.map(pokemon => {
        return {
          ...pokemon, picture: `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${pokemon.no}.png`
        }
      })
    });
  }
}

export class Pokemon {
  id: number = 0;
  name: string = '';
  no: string = '';
  level: number = 0;

  picture: string = ``;

  constructor() {
  }
}

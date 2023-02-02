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
    this.pokemonService.getPokemonList().subscribe(pokemonList => this.pokemonList = pokemonList);
  }
}

export class Pokemon {
  id: number = 0;
  name: string = '';
  No: number = 0;
  level: number = 0;

  picture: string = ``

  constructor() {
  }
}

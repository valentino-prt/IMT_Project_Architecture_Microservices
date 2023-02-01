import {Component} from '@angular/core';

@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})

export class PokemonComponent {
  pokemonList: Pokemon[] = [
    {
      id: 10,
      name: "Sabelette",
      hp: 19,
      cp: 3,
      picture: "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/027.png",
      types: ["Normal"],
      created: new Date()
    },
    {
      id: 11,
      name: "Mélofée",
      hp: 25,
      cp: 5,
      picture: "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/035.png",
      types: ["Fée"],
      created: new Date()
    },
    {
      id: 12,
      name: "Groupix",
      hp: 17,
      cp: 8,
      picture: "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/037.png",
      types: ["Feu"],
      created: new Date()
    }
  ];
}

export class Pokemon {
  // @ts-ignore
  id: number;
  // @ts-ignore
  hp: number;
  // @ts-ignore
  cp: number;
  // @ts-ignore
  name: string;
  // @ts-ignore
  picture: string;
  // @ts-ignore
  types: Array<string>;
  // @ts-ignore
  created: Date;
}

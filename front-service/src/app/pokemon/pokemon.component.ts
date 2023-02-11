import {Component, OnInit} from '@angular/core';
import {PokemonService} from "../pokemon.service";
import {TrainerService} from "../trainer.service";


@Component({
  selector: 'app-pokemon',
  templateUrl: './pokemon.component.html',
  styleUrls: ['./pokemon.component.css']
})

export class PokemonComponent implements OnInit {
  pokemonList: MyPokemon[] = [];

  constructor(private pokemonService: PokemonService, private trainerService: TrainerService) {
  }

  ngOnInit() {
    setInterval(() => {
      this.pokemonService.getPokemonList().subscribe(pokemonList => {
        this.pokemonList = pokemonList;
        this.pokemonList = this.pokemonList.map(pokemon => {
          return {
            ...pokemon,
            picture: `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${pokemon.no}.png`
          }
        })
      });
    }, 1000)

  }


  public sellPokemon(pokemon: MyPokemon) {
    this.trainerService.addMoney(pokemon.level * 10).subscribe(() => {
    })

    this.pokemonService.removePokemon(pokemon.id).subscribe(() => {
      this.pokemonList = this.pokemonList.filter(p => p.id !== pokemon.id);
    })
  }
}


class Pokemon {
  id: number;
  name: string;
  no: string;


  constructor(id: number, name: string, no: string) {
    this.id = id;
    this.name = name;
    this.no = no;
  }
}

export class PokemonForSale extends Pokemon {
  price: number;
  picture: string;


  constructor(id: number, name: string, no: string, price: number) {
    super(id, name, no);
    this.price = price;
    this.picture = `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${this.no}.png`

  }
}

export class Egg extends Pokemon {
  hatchingTime: number;

  constructor(id: number, name: string, no: string, hatchingTime: number) {
    super(id, name, no);
    this.hatchingTime = hatchingTime;
  }
}

export class MyPokemon extends Pokemon {
  level: number;
  picture: string;

  constructor(id: number, name: string, no: string, level: number) {
    super(id, name, no);
    this.level = level;
    this.picture = `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${this.no}.png`

  }
}

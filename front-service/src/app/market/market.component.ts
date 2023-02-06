import {Component, OnInit} from '@angular/core';
import {PokemonService} from "../pokemon.service";
import {TrainerService} from "../trainer.service";
import {PokemonForSale} from "../pokemon/pokemon.component";
import {MarketService} from "../market.service";

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.css']
})
export class MarketComponent implements OnInit {
  pokemonList: PokemonForSale[] = [];

  constructor(private marketService: MarketService) {
  }

  ngOnInit() {
    setInterval(() => {
      this.marketService.getPokemonsForSell().subscribe(pokemonList => {
        this.pokemonList = pokemonList;
        this.pokemonList = this.pokemonList.map(pokemon => {
          return {
            ...pokemon, picture: `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${pokemon.no}.png`
          }
        })
      });
    }, 10000)

  }


  BuyPokemon(pokemon: PokemonForSale) {
    this.marketService.removePokemon(pokemon.id).subscribe(() => {
      this.pokemonList = this.pokemonList.filter(p => p.id !== pokemon.id);
      console.log("pokemon vendu");
    })
  }

}

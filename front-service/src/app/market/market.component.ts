import {Component, OnInit} from '@angular/core';
import {PokemonForSale} from "../pokemon/pokemon.component";
import {MarketService} from "../market.service";
import {TrainerService} from "../trainer.service";

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.css']
})
export class MarketComponent implements OnInit {
  pokemonList: PokemonForSale[] = [];

  constructor(private marketService: MarketService, private trainersService: TrainerService) {
  }

  ngOnInit() {
    this.callMarketService();
    setInterval(() => {
      this.callMarketService();
    }, 10000000)

  }

  BuyPokemon(pokemon: PokemonForSale) {
    this.marketService.removePokemon(pokemon.id).subscribe(() => {
      this.pokemonList = this.pokemonList.filter(p => p.id !== pokemon.id);
      console.log("pokemon vendu");
    });
    this.trainersService.subMoney(pokemon.price).subscribe(() => {
      console.log("argent enlevé");
    });
  }

  private callMarketService() {
    this.marketService.getPokemonsForSell().subscribe(pokemonList => {
      this.pokemonList = pokemonList;
      this.pokemonList = this.pokemonList.map(pokemon => {
        return {
          ...pokemon, picture: `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${pokemon.no}.png`
        }
      })
    });
  }

}

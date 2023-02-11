import {Component, OnInit} from '@angular/core';
import {Egg, PokemonForSale} from "../pokemon/pokemon.component";
import {MarketService} from "../market.service";
import {TrainerService} from "../trainer.service";
import {PokemonService} from "../pokemon.service";

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrls: ['./market.component.css']
})
export class MarketComponent implements OnInit {
  pokemonList: PokemonForSale[] = [];

  constructor(private marketService: MarketService, private trainersService: TrainerService, private pokemonService: PokemonService) {
  }

  ngOnInit() {
    this.callMarketService();
    setInterval(() => {
      this.callMarketService();
    }, 1000);
  }

  BuyPokemon(pokemon: PokemonForSale) {
    this.trainersService.subMoney(pokemon.price).subscribe(() => {
    });
    if (this.trainersService.transactionStatus) {
      this.marketService.removePokemon(pokemon.id).subscribe(() => {
        this.pokemonList = this.pokemonList.filter(p => p.id !== pokemon.id);
      });
      let egg = this.PokemonForSaleToEgg(pokemon);
      this.pokemonService.addEgg(egg).subscribe(() => {
      });
    }
  }

  private callMarketService() {
    this.marketService.getPokemonsForSell().subscribe(pokemonList => {
      this.pokemonList = pokemonList;
      this.pokemonList = this.pokemonList.map(pokemon => {
        return {
          ...pokemon,
          picture: `https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${pokemon.no}.png`
        }
      })
    });
  }

  private PokemonForSaleToEgg(pokemon: PokemonForSale) {
    let randomInt = Math.floor(Math.random() * 10) + 1;
    return new Egg(pokemon.id, pokemon.name, pokemon.no, randomInt);
  }
}

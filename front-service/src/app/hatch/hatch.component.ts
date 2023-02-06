import {Component, OnInit} from '@angular/core';
import {compareNumbers} from "@angular/compiler-cli/src/version_helpers";
import {PokemonService} from "../pokemon.service";
import {Egg} from "../pokemon/pokemon.component";

@Component({
  selector: 'app-hatch',
  templateUrl: './hatch.component.html',
  styleUrls: ['./hatch.component.css']
})
export class HatchComponent implements OnInit {
  eggList: Egg[] = [];

  constructor(private pokemonService: PokemonService) {
  }

  ngOnInit() {
    setInterval(() => {
      this.pokemonService.getEggList().subscribe(eggList => {
        return this.eggList = eggList;
      })
    }, 1000)
  }

}

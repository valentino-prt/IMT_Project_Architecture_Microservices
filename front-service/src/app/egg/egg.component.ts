import {Component, OnInit} from '@angular/core';
import {compareNumbers} from "@angular/compiler-cli/src/version_helpers";
import {PokemonService} from "../pokemon.service";

@Component({
  selector: 'app-egg',
  templateUrl: './egg.component.html',
  styleUrls: ['./egg.component.css']
})
export class EggComponent implements OnInit {
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

export class Egg {
  hatchingTime: number;
  name: string;
  no: number;

  constructor(hatchingTime: number, name: string, no: number) {
    this.hatchingTime = hatchingTime;
    this.name = name;
    this.no = no;

  }

}

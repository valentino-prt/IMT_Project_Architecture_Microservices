import {Component, OnInit} from '@angular/core';
import {PokemonService} from "../pokemon.service";
import {Pokemon} from "../pokemon/pokemon.component";

@Component({
  selector: 'app-inventaire_egg',
  templateUrl: './inventaire_egg.component.html',
  styleUrls: ['./inventaire_egg.component.css']
})

export class Inventaire_eggComponent implements OnInit {
  eggList: Egg[] = [];

  constructor(private pokemonService: PokemonService) {
  }

  ngOnInit() {
    setInterval(() => {
      this.pokemonService.getEggListInv().subscribe(eggList => {
        this.eggList = eggList;
      });
    }, 1000)

  }
  public hatch(egg: Egg) {
    this.pokemonService.hatch(egg).subscribe(() => {
      console.log("oeuf = ", egg);
      }
    )
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

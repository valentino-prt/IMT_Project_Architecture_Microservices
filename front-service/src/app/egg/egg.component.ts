import {Component, OnInit} from '@angular/core';
import {PokemonService} from "../pokemon.service";
import {Egg} from "../pokemon/pokemon.component";
import {TrainerService} from "../trainer.service";

@Component({
  selector: 'app-egg',
  templateUrl: './egg.component.html',
  styleUrls: ['./egg.component.css']
})

export class EggComponent implements OnInit {
  eggList: Egg[] = [];

  constructor(private pokemonService: PokemonService, private trainerService: TrainerService) {
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
    this.pokemonService.removeEgg(egg.id).subscribe(() => {
      console.log("oeuf = ", egg);
    });

    this.trainerService.addXP(10).subscribe(() => {
      console.log(" + 10 xp ");
    });
  }
}

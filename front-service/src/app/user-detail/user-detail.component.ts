import {Component, OnInit} from '@angular/core';
import {TrainerService} from "../trainer.service";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  trainer: Trainer = new Trainer(0, "Sacha", 0, 0, 0);

  constructor(private traineService: TrainerService) {
  }

  ngOnInit() {
    this.traineService.getTrainer().subscribe(trainer => {
      this.trainer = trainer;
    })
  }

}


export class Trainer {
  id: number;
  name: string;
  level: number;
  gold: number;
  xp: number;

  constructor(id: number, name: string, level: number, gold: number, xp: number) {
    this.id = id;
    this.name = name;
    this.level = level;
    this.gold = gold;
    this.xp = xp;
  }

}

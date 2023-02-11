import {Component, OnInit} from '@angular/core';
import {TrainerService} from "../trainer.service";

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  trainerList: Trainer[] = [];

  constructor(private trainerService: TrainerService) {
    let trainer = new Trainer(0, "Manny42", 1, 200, 0);
    this.trainerService.addTrainer(trainer).subscribe(() => {
    });
  }

  ngOnInit() {
    setInterval(() => {
      this.trainerService.getTrainers().subscribe(trainers => {
        this.trainerList = trainers;
      });
    }, 1000)

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

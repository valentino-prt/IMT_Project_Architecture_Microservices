import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  trainer: Trainer;

  constructor() {
    this.trainer = new Trainer(1, "Ash", 1, 100, 0);
  }

  ngOnInit() {

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

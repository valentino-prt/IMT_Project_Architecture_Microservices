import {Component} from '@angular/core';

@Component({
  selector: 'app-egg',
  templateUrl: './egg.component.html',
  styleUrls: ['./egg.component.css']
})
export class EggComponent {
  eggList: Egg[] = [
    {
      name: 'Pikachu',
      ht: 3
    },
    {
      name: 'Pikachu',
      ht: 3
    },
    {
      name: 'Pikachu',
      ht: 3
    },
  ];
}

export class Egg {
  // @ts-ignore
  ht: number;
  // @ts-ignore
  name: string;
}

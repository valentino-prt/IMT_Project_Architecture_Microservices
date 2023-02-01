import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeButtonComponent } from './home-button/home-button.component';
import { PokemonComponent } from './pokemon/pokemon.component';
import { EggComponent } from './egg/egg.component';
import { BorderCardDirective } from './border-card.directive';

@NgModule({
  declarations: [
    AppComponent,
    HomeButtonComponent,
    PokemonComponent,
    EggComponent,
    BorderCardDirective
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

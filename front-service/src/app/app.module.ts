import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HomeButtonComponent} from './home-button/home-button.component';
import {PokemonComponent} from './pokemon/pokemon.component';
import {EggComponent} from './egg/egg.component';
import {BorderCardDirective} from './border-card.directive';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HomeButtonComponent,
    PokemonComponent,
    EggComponent,
    BorderCardDirective
  ],
  imports: [
    BrowserModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

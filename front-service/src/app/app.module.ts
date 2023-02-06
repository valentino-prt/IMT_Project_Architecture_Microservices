import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HomeButtonComponent} from './home-button/home-button.component';
import {PokemonComponent} from './pokemon/pokemon.component';
import {HatchComponent} from './hatch/hatch.component';
import {BorderCardDirective} from './border-card.directive';
import {HttpClientModule} from "@angular/common/http";
import {UserDetailComponent} from './user-detail/user-detail.component';
import {EggComponent} from "./egg/egg.component";
import { MarketComponent } from './market/market.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeButtonComponent,
    EggComponent,
    PokemonComponent,
    HatchComponent,
    BorderCardDirective,
    UserDetailComponent,
    MarketComponent,
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

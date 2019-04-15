import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlacesSearchComponent } from './places-search/places-search.component';
import { PlacesSearchService } from "./places-search.service";
import { HttpClientModule } from "@angular/common/http";

import { FormsModule } from "@angular/forms";
import { BookingListComponent } from './booking-list/booking-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PlacesSearchComponent,
    BookingListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PlacesSearchService],
  bootstrap: [AppComponent]
})
export class AppModule { }

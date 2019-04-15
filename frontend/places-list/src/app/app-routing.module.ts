import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookingListComponent } from './booking-list/booking-list.component';
import { PlacesSearchComponent } from './places-search/places-search.component';

const routes: Routes = [
  {
    path: 'bookings',
    component: BookingListComponent,
    pathMatch: 'full'
  },

  {
    path: '',
    component: PlacesSearchComponent,
    pathMatch: 'full'
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

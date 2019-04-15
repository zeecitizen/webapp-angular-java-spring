import { Component, OnInit } from '@angular/core';
import { Bookings } from "../bookings";

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {

  responseResults: Bookings;

  constructor() { }

  ngOnInit() {
    //code to retrieve bookings
        //backend api communication 
    // let id = str(item.geometry.location.lat) + str(item.geometry.location.lng)
    /*    this.http.get('http://localhost:8080/makeBooking/{params}' + query)
          .toPromise()
          .then((response) => {
            resolve(response as NearbyPlaces)
          }, (error) => {
            reject(error);
          }) */

  }

}

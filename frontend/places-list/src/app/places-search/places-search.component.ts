import { Component, OnInit } from '@angular/core';
import { NearbyPlaces } from '../nearby-places'
import { PlacesSearchService } from '../places-search.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-places-search',
  templateUrl: './places-search.component.html',
  styleUrls: ['./places-search.component.css']
})
export class PlacesSearchComponent implements OnInit {

  searchResults: NearbyPlaces;
  type: string;
  keyword: string;
  bookings: Array<number> = [];

  constructor(private PlacesSearchService: PlacesSearchService, private router: Router) { }

  ngOnInit() {
  
    this.PlacesSearchService.placesSearch('location=48.137154,11.576124&radius=25000&type=restaurant&keyword=china&key=AIzaSyA3dmC5e16AZaB9cMnaPG3YFaOYelHOzv4').then((response) => {
      this.searchResults = response;
    }, (error) => {
      alert("Error: " + error.statusText)
    })
  }


  placesSearch = () => {
    this.PlacesSearchService.placesSearch('location=48.137154,11.576124&radius=25000&type='+this.type+'&keyword='+this.keyword+'&key=AIzaSyA3dmC5e16AZaB9cMnaPG3YFaOYelHOzv4').then((response) => {
      this.searchResults = response;
    }, (error) => {
      alert("Error: " + error.statusText)
    })
  }



  addBookings = (item) => {
    this.bookings.push(item.geometry.location.lat);
    //backend api communication 
    // let id = str(item.geometry.location.lat) + str(item.geometry.location.lng)
    /*    this.http.post('http://localhost:8080/makeBooking/{params}' + query)
          .toPromise()
          .then((response) => {
            resolve(response as NearbyPlaces)
          }, (error) => {
            reject(error);
          }) */

  }

  checkBookings = (item) => {
    if (this.bookings){
      return this.bookings.indexOf(item.geometry.location.lat) > -1;
    }
    else {
      return false;
    }
    
  }

  viewBookings = ()=> {
    this.router.navigate(['/bookings'])
  }

}

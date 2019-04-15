import { Component } from '@angular/core';
import { PlacesSearchService } from "./places-search.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [PlacesSearchService]
})
export class AppComponent {
  constructor(private PlacesSearchService: PlacesSearchService) {

  }


  ngOnInit() {
    this.PlacesSearchService.placesSearch('location=48.137154,11.576124&radius=25000&type=restaurant&keyword=china&key=AIzaSyA3dmC5e16AZaB9cMnaPG3YFaOYelHOzv4').then((response) => {
      //alert("Next-Page-Token:" + response.next_page_token);
    }, (error) => {
      alert("Error: " + error.statusText);
    })
  }
  title = 'places-list';
}

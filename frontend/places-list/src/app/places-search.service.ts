import { Injectable, Inject } from '@angular/core';
import { NearbyPlaces } from './nearby-places';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import 'rxjs/add/operator/toPromise';


@Injectable({
  providedIn: 'root'
})
export class PlacesSearchService {

  cachedValues: Array<{
    [query: string]: NearbyPlaces
  }> = [];

  cachedUsersValues: Array<{
    [query: string]: NearbyPlaces
  }> = [];

  constructor(private http: HttpClient) {


  }

  placesSearch = (query: string): Promise<NearbyPlaces> => {
    let promise = new Promise<NearbyPlaces>((resolve, reject) => {
      if (this.cachedValues[query]) {
        resolve(this.cachedValues[query])
      }
      else {
        this.http.get('https://maps.googleapis.com/maps/api/place/nearbysearch/json?' + query)
          .toPromise()
          .then((response) => {
            resolve(response as NearbyPlaces)
          }, (error) => {
            reject(error);
          })
      }
    })
    return promise;
  }



  }


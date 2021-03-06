import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Land } from './land';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LandService {

  constructor(private http: HttpClient, private router: Router) { }
  public addLandByFarmer(land: Land): Observable<any> {
    console.log("bala");
    return this.http.post<any>('/registerLand', land, { responseType: 'text' as 'json' })
  }
  public viewAllLands() {
    console.log("bala");
    return this.http.get<any>('/getAllLands')
  }

  Searchcode(loginId : any) { 
  //  var header = new Headers(); 
   // header.append('Content-type', 'application/json'); 
    return this.http.post<any>( '/getLandById', loginId); 
}

  public delete(surveyNumber: any): any {
    console.log("Deleted");
    return this.http.post('/deleteland', surveyNumber);
  }

  public editland(land: Land): any {
    console.log("Updated");
    return this.http.post('/updateland', land);
  }
}

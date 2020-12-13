import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Developper } from '../models/developper';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DeveloppersService {

  constructor(private http: HttpClient) { }

  public getDeveloppersList(): Observable<Developper[]> {
    return this.http.get<Developper[]>(`${environment.url}/developpers`);
  }

  public deleteDevelopper(id: number): Observable<any> {
    return this.http.delete(`${environment.url}/developpers/${id}`);
  }
  public createDevelopper(developper: Developper): Observable<Developper> {
    return this.http.post<Developper>(`${environment.url}/developpers`, developper);
  }
}

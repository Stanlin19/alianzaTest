import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { ClientDTO } from "../shared/Client";


@Injectable({
  providedIn: "root"
})
export class ClientService {
  rutaApi = "http://localhost:8080/client";

  constructor(private http: HttpClient) {}

  findAll() {
    return this.http.get(`${this.rutaApi}`);
  }

  findBySharedKey(sharedKey: string) {
    return this.http.get(`${this.rutaApi}/${sharedKey}`);
  }

  save(clientDTO: ClientDTO) {
    return this.http.post(`${this.rutaApi}`, clientDTO);
  }


  delete(id: string | number) {
    return this.http.delete(`${this.rutaApi}/${id}`);
  }
}
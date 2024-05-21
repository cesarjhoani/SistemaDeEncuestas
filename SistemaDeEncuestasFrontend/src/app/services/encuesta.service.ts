import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Encuesta } from '../models/encuesta';

@Injectable({
  providedIn: 'root'
})
export class EncuestaService {

  private baseUrl="http://localhost:8080/api/encuestas"
  constructor(private http:HttpClient) { }


  // para listar las encuestas de la base de datos
  listarEncuestas():Observable<Encuesta[]>{
    return this.http.get<Encuesta[]>(`${this.baseUrl}`)
  }

   //obtenemos todas las encuestas por id en la base de datos
   obtenerEncuestaPorId(encuestaId:number):Observable<Encuesta>{
    return this.http.get<Encuesta>(`${this.baseUrl}/${encuestaId}`)
   }

   // para crear una encuesta

   crearEncuesta(encuesta:Encuesta):Observable<Encuesta>{
      return this.http.post<Encuesta>(`${this.baseUrl}`,encuesta)//{titulo}
   }

   //para acutualizar encuesta
   actualizarEncuesta(id:number,encuesta:Encuesta):Observable<Encuesta>{
     return this.http.put<Encuesta>(`${this.baseUrl}/${id}`,encuesta)
   }

   // para eliminar la encuesta
   eliminarEncuesta(id:number):Observable<void>{
      return this.http.delete<void>(`${this.baseUrl}/${id}`)
   }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pregunta } from '../models/pregunta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PreguntaService {
  private baseUrl = "http://localhost:8080/api/preguntas"

  constructor(private http:HttpClient) { }

  //crear agregar Pregunta A Encuesta

  agregarPreguntaAEncuesta(encuestaId:number,pregunta:Pregunta):Observable<Pregunta>{
    return this.http.post<Pregunta>(`${this.baseUrl}/agregar/${encuestaId}`,pregunta)
  }

  // listar preguntas por encuesta

  obtenerPreguntasPorEncuestas(encuestaId:number):Observable<Pregunta[]>{
      return this.http.get<Pregunta[]>(`${this.baseUrl}/por-encuesta/${encuestaId}`)
  }

  //obtener pregunta por id
  obtenerDetallesPregunta(preguntaId:number):Observable<Pregunta>{
      return this.http.get<Pregunta>(`${this.baseUrl}/${preguntaId}`)
  }
    // para actualizar la pregunta
  actualizarPregunta(preguntaId:number,pregunta:Pregunta,encuestaId:number):Observable<Pregunta>{
    return this.http.put<Pregunta>(`${this.baseUrl}/${preguntaId}/encuesta/${encuestaId}`,pregunta)
  }

  // eliminar una pregunta
  eliminarPregunta(preguntaId:number):Observable<void>{
      return this.http.delete<void>(`${this.baseUrl}/${preguntaId}`)
  }


}

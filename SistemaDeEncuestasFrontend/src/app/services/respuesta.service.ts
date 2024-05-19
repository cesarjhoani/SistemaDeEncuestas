import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Respuesta } from '../models/respuesta';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RespuestaService {

  private baseUrl="http://localhost:8080/api/respuestas"
  constructor(private http:HttpClient) { }

  agregarRespuestaApregunta(preguntaId:number,respuesta:Respuesta):Observable<Respuesta>{
      return this.http.post<Respuesta>(`${this.baseUrl}/agregar/${preguntaId}`,respuesta)
  }

  obtenerRespuestasPorPregunta(preguntaId:number):Observable<Respuesta[]>{
      return this.http.get<Respuesta[]>(`${this.baseUrl}/por-pregunta/${preguntaId}`)
  }

  obtenerDetallesRespuesta(respuestaId:number):Observable<Respuesta>{
      return this.http.get<Respuesta>(`${this.baseUrl}/${respuestaId}`)
  }

  actualizarRespuestaaApregunta(respuestaId:number,respuesta:Respuesta):Observable<Respuesta>{
      return this.http.put<Respuesta>(`${this.baseUrl}/${respuestaId}`,respuesta)
  }

  eliminarRespuesta(respuestaId:number):Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/${respuestaId}`)
  }
}

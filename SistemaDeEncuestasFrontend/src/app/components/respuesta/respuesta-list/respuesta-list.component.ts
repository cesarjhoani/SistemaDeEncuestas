import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { RespuestaService } from '../../../services/respuesta.service';
import { Respuesta } from '../../../models/respuesta';

@Component({
  selector: 'app-respuesta-list',
  standalone: true,
  imports: [NgFor,RouterLink,NgIf],
  templateUrl: './respuesta-list.component.html',
  styleUrl: './respuesta-list.component.css'
})
export class RespuestaListComponent {

  listaRespuestas:Respuesta[] = [];
  preguntaId:number | undefined;

  constructor(private route:ActivatedRoute,private respuestaService:RespuestaService){}

  ngOnInit(){
    this.route.params.subscribe(params=>{
      this.preguntaId=Number(params['preguntaId']);
    })
    this.obtenerRespuestasPorPregunta();
  }

  obtenerRespuestasPorPregunta():void{
      if(this.preguntaId){
        this.respuestaService.obtenerRespuestasPorPregunta(this.preguntaId).subscribe(listaRespuestas=>{
          this.listaRespuestas = listaRespuestas;
        })
      }
  }

  eliminarRespuesta(respuestaId:number):void{
      this.respuestaService.eliminarRespuesta(respuestaId).subscribe(()=>{
        this.obtenerRespuestasPorPregunta();
      })
  }

}

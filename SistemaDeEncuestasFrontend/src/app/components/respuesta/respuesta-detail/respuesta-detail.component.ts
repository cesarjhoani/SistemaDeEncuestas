import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RespuestaService } from '../../../services/respuesta.service';
import { Respuesta } from '../../../models/respuesta';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-respuesta-detail',
  standalone: true,
  imports: [NgIf],
  templateUrl: './respuesta-detail.component.html',
  styleUrl: './respuesta-detail.component.css'
})
export class RespuestaDetailComponent {

  respuesta:Respuesta | undefined;
  
  constructor(private route:ActivatedRoute,private respuestaService:RespuestaService){}


  ngOnInit(){
    this.obtenerDetallesRespuesta();
  }

  obtenerDetallesRespuesta():void{
    const respuestaId = Number(this.route.snapshot.paramMap.get('id'));
      this.respuestaService.obtenerDetallesRespuesta(respuestaId).subscribe(respuesta=>{
        this.respuesta = respuesta;
      })
    
      
  }
}

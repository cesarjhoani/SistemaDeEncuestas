import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Respuesta } from '../../../models/respuesta';
import { RespuestaService } from '../../../services/respuesta.service';

@Component({
  selector: 'app-respuesta-form',
  standalone: true,
  imports: [FormsModule,RouterLink],
  templateUrl: './respuesta-form.component.html',
  styleUrl: './respuesta-form.component.css'
})
export class RespuestaFormComponent {

respuesta:Respuesta = new Respuesta();
respuestaId: number = 0;
preguntaId:number = 0;

constructor(private respuestaService:RespuestaService,private route:ActivatedRoute,private router:Router){}

ngOnInit(){

  this.route.paramMap.subscribe(params=>{
    this.preguntaId = Number(params.get('preguntaId'))// recupero por medio del list respuestas
  })
this.obtenerRespuesta();


}

    obtenerRespuesta():void{
      this.respuestaId = Number(this.route.snapshot.paramMap.get('respuestaId'));// obtengo del editar
      this.respuestaService.obtenerDetallesRespuesta(this.respuestaId).subscribe(respuesta=>{
        this.respuesta = respuesta;
      })
    }

    guardarOactualizarRespuesta():void{
      if(this.respuesta.id){
        this.respuestaService.actualizarRespuestaaApregunta(this.respuestaId,this.respuesta).subscribe(()=>{
              this.router.navigate(['/preguntas/respuestas/'+this.preguntaId])
        })
      }else{
        this.respuestaService.agregarRespuestaApregunta(this.preguntaId,this.respuesta).subscribe(()=>{
          this.router.navigate(['/preguntas/respuestas/'+this.preguntaId])
        })
      }
    }

}

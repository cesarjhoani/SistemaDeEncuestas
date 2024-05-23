import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { PreguntaService } from '../../../services/pregunta.service';
import { Pregunta } from '../../../models/pregunta';
import { FormsModule, NgModel } from '@angular/forms';

@Component({
  selector: 'app-pregunta-form',
  standalone: true,
  imports: [FormsModule,RouterLink],
  templateUrl: './pregunta-form.component.html',
  styleUrl: './pregunta-form.component.css'
})
export class PreguntaFormComponent {

    pregunta:Pregunta = new Pregunta();
    preguntaId:number = 0;
    encuestaId:number = 0;

  constructor(private route:ActivatedRoute,private preguntaService:PreguntaService,private router:Router){}

    ngOnInit(){
        this.obtenerPregunta();
        
        this.route.paramMap.subscribe(params=>{
          this.encuestaId = Number(params.get('encuestaId'));
          //this.preguntaId = Number(params.get('id'));
        })
    }

    obtenerPregunta():void{
      this.preguntaId = Number(this.route.snapshot.paramMap.get('preguntaId'));
      //this.encuestaId = Number(this.route.snapshot.paramMap.get('encuestaId'));

      if(this.preguntaId){
        this.preguntaService.obtenerDetallesPregunta(this.preguntaId).subscribe(pregunta=>{
          this.pregunta = pregunta;
        })
      }
    }

    guardarOactualizarPreguntaAEncuesta():void{
      if(this.pregunta.id){
        this.preguntaService.actualizarPregunta(this.preguntaId,this.pregunta,this.encuestaId).subscribe(()=>{
            this.router.navigate(['/encuestas/'+this.encuestaId+'/preguntas'])
        })
      }else{
        this.preguntaService.agregarPreguntaAEncuesta(this.encuestaId,this.pregunta).subscribe(()=>{
          this.router.navigate(['/encuestas/'+this.encuestaId+'/preguntas'])
        })
      }
    }


}

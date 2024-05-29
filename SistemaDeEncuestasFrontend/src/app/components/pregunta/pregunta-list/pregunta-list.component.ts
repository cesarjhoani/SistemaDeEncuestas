import { Component } from '@angular/core';
import { Pregunta } from '../../../models/pregunta';
import { PreguntaService } from '../../../services/pregunta.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { CommonModule, NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-pregunta-list',
  standalone: true,
  imports: [NgFor,RouterLink,NgIf,CommonModule],
  templateUrl: './pregunta-list.component.html',
  styleUrl: './pregunta-list.component.css'
})
export class PreguntaListComponent {

  listaPreguntas: Pregunta[] = [];
  encuestaId: number | undefined;

  constructor(private preguntaService: PreguntaService, private router: Router, private route: ActivatedRoute) { }


  ngOnInit() {

    this.route.params.subscribe(params=>{
      this.encuestaId = Number(params['id']);//recupero este id de  {path:':id/preguntas',component:PreguntaListComponent}
    })
    this.listarPreguntasPorEncuestas();
  }

  listarPreguntasPorEncuestas(): void {
    if (this.encuestaId) {
      this.preguntaService.obtenerPreguntasPorEncuestas(this.encuestaId).subscribe(preguntas => {
        this.listaPreguntas = preguntas
      })
    }
  }

  eliminarPregunta(preguntaId:number){
    this.preguntaService.eliminarPregunta(preguntaId).subscribe(pregunta=>{
      console.log(pregunta)
      this.listarPreguntasPorEncuestas();
    })
  }

  verRespuestas(preguntaId:number):void{
      this.router.navigate(['/preguntas/respuestas/',preguntaId])
  }


}

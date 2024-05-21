import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { EncuestaService } from '../../../services/encuesta.service';
import { Encuesta } from '../../../models/encuesta';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-encuesta-list',
  standalone: true,
  imports: [RouterLink,NgFor],
  templateUrl: './encuesta-list.component.html',
  styleUrl: './encuesta-list.component.css'
})
export class EncuestaListComponent {

  encuestas:Encuesta[] = [];

  constructor(private encuestaService: EncuestaService,
    private route: ActivatedRoute, private router: Router) { }


    ngOnInit(): void{
          this.listarEncuestas();
    }

    listarEncuestas():void{
        this.encuestaService.listarEncuestas().subscribe(encuestas=>{
          this.encuestas=encuestas
        })
    }

    eliminarEncuesta(encuestaId:number){
      this.encuestaService.eliminarEncuesta(encuestaId).subscribe(encuesta=>{
        console.log(encuesta)
        this.listarEncuestas();
      })
    }

    verPreguntas(encuestaId:number):void{
      this.router.navigate(['/encuestas',encuestaId,'preguntas']);
   }

}

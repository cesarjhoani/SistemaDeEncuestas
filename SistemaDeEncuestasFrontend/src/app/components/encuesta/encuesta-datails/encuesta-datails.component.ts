import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Encuesta } from '../../../models/encuesta';
import { EncuestaService } from '../../../services/encuesta.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-encuesta-datails',
  standalone: true,
  imports: [RouterLink,NgIf],
  templateUrl: './encuesta-datails.component.html',
  styleUrl: './encuesta-datails.component.css'
})
export class EncuestaDatailsComponent {

  encuesta:Encuesta | undefined

  constructor(private route:ActivatedRoute,private encuestaService:EncuestaService){}//el activatedRoute es para aceder a los parametros de la ruta

  ngOnInit():void{
    this.obtenerDetalleEncuesta();

  }

  obtenerDetalleEncuesta():void{
    const id= Number(this.route.snapshot.paramMap.get('id'));
    this.encuestaService.obtenerEncuestaPorId(id).subscribe(encuesta=>{
      this.encuesta=encuesta;
    })
  }
}

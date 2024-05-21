import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { EncuestaService } from '../../../services/encuesta.service';
import { Encuesta } from '../../../models/encuesta';
import { FormsModule, NgModel } from '@angular/forms';

@Component({
  selector: 'app-encuesta-form',
  standalone: true,
  imports: [RouterLink,FormsModule],
  templateUrl: './encuesta-form.component.html',
  styleUrl: './encuesta-form.component.css'
})
export class EncuestaFormComponent {

  //titulo: string = "";
  encuesta: Encuesta = new Encuesta();
  encuestaId: number = 0;

  constructor(private encuestaService: EncuestaService,
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    this.obtenerEncuesta();//devuelve la encuesta al html del form
  }

  obtenerEncuesta(): void {
    this.encuestaId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.encuestaId) {
      this.encuestaService.obtenerEncuestaPorId(this.encuestaId).subscribe(encuesta => {
        //this.titulo = encuesta.titulo;
        this.encuesta = encuesta;
      })
    }
  }

  crearEncuestaOactualizar(): void {
    if (this.encuesta.id) {
      this.encuestaService.actualizarEncuesta(this.encuestaId, this.encuesta).subscribe(() => {

        this.router.navigate(['/encuestas'])
      })
    } else {
      this.encuestaService.crearEncuesta(this.encuesta).subscribe(guardarEncuesta => {
        console.log(guardarEncuesta)
        this.router.navigate(['/encuestas'])
      })
    }
  }




}

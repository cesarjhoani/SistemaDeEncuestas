import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
import { EncuestaListComponent } from './components/encuesta/encuesta-list/encuesta-list.component';
import { EncuestaFormComponent } from './components/encuesta/encuesta-form/encuesta-form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,NavbarComponent,EncuestaFormComponent],//directiva de cada componente
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'SistemaDeEncuestasFrontend';
}

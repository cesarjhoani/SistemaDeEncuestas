import { Routes } from '@angular/router';
import { EncuestaListComponent } from './components/encuesta/encuesta-list/encuesta-list.component';
import { EncuestaFormComponent } from './components/encuesta/encuesta-form/encuesta-form.component';
import { EncuestaDatailsComponent } from './components/encuesta/encuesta-datails/encuesta-datails.component';
import { PreguntaListComponent } from './components/pregunta/pregunta-list/pregunta-list.component';
import { PreguntaFormComponent } from './components/pregunta/pregunta-form/pregunta-form.component';
import { PreguntaDetailComponent } from './components/pregunta/pregunta-detail/pregunta-detail.component';
import { RespuestaListComponent } from './components/respuesta/respuesta-list/respuesta-list.component';
import { RespuestaFormComponent } from './components/respuesta/respuesta-form/respuesta-form.component';
import { RespuestaDetailComponent } from './components/respuesta/respuesta-detail/respuesta-detail.component';

export const routes: Routes = [

    {
        path:'',component:EncuestaListComponent
    },
    {
        path:'encuestas',
        children:[
            {path:'',component:EncuestaListComponent},//listar encuestas
            {path:'nueva',component:EncuestaFormComponent},//agregar encuesta
            {path:'editar/:id',component:EncuestaFormComponent},//editar encuesta
            {path:':id',component:EncuestaDatailsComponent},//detalle de la encuesta
            {path:':id/preguntas',component:PreguntaListComponent}//listar pregunta por encuesta
        ]
    },
    {
        path:'preguntas',
        children:[
            {path:'nueva/:encuestaId',component:PreguntaFormComponent},//agregar pregunta a encuesta
            {path:'editar/:preguntaId/encuesta/:encuestaId',component:PreguntaFormComponent},//editar pregunta a encuesta
            {path:':id',component:PreguntaDetailComponent},//detalle pregunta
            {path:'respuestas/:preguntaId',component:RespuestaListComponent},//listar respuesta por pregunta
        ]
    },
    {
        path:'respuestas',
        children:[
            {path:'nueva/:preguntaId',component:RespuestaFormComponent},//agregar respuesta a pregunta
            {path:'editar/:respuestaId/pregunta/:preguntaId',component:RespuestaFormComponent},//editar respuesta a pregunta, recuerde que este "preguntaId" solo lo use para listar las respuestas por preguntas 
            {path:':id',component:RespuestaDetailComponent}//detalle de respuesta
        ]
    }
    
];

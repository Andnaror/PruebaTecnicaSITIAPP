import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginUsuarioComponent } from './Componentes/login-usuario/login-usuario.component';
import { RegistroUsuarioComponent } from './Componentes/registro-usuario/registro-usuario.component';

@NgModule({
  imports: [RouterModule.forRoot([
  { path:"",component:AppComponent, pathMatch:"full"},
  { path: "login", component: LoginUsuarioComponent, pathMatch: "full" },
  { path: "register", component: RegistroUsuarioComponent, pathMatch: "full" }])],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component } from '@angular/core';

@Component({
  selector: 'app-login-usuario',
  templateUrl: './login-usuario.component.html',
  styleUrls: ['./login-usuario.component.sass'  ]
})
export class LoginUsuarioComponent {
  usuario: string="";
  password: string="";

  constructor() {}

  login() {
    console.log(this.usuario);
    console.log(this.password);
  }
}

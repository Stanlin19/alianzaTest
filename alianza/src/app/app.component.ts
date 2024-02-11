import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ClientComponent } from "./client/client.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, ClientComponent]
})
export class AppComponent{
  title = 'alianza';

  
}

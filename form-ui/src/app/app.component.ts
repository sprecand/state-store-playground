import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { RequestOverviewComponent } from './request-overview/request-overview.component';
import { ItemOverviewComponent } from './item-overview/item-overview.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterLink,
    RouterOutlet, 
    RequestOverviewComponent, 
    ItemOverviewComponent
  ],
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'form-ui';
}

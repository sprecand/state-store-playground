import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { RequestOverviewComponent } from './request-overview/request-overview.component';
import { RealEstateOverviewComponent } from './real-estate-overview/real-estate-overview.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterLink,
    RouterOutlet, 
    RequestOverviewComponent, 
    RealEstateOverviewComponent
  ],
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'State Store Demo App';
}

import { Routes } from '@angular/router';
import { RequestOverviewComponent } from './request-overview/request-overview.component';
import { RealEstateOverviewComponent } from './real-estate-overview/real-estate-overview.component';

export const routes: Routes = [
  { path: 'request-overview', component: RequestOverviewComponent },
  { path: 'item-overview', component: RealEstateOverviewComponent },
  { path: '', redirectTo: '/item-overview', pathMatch: 'full' } 
];
import { Routes } from '@angular/router';
import { RequestOverviewComponent } from './request-overview/request-overview.component';
import { RealEstateOverviewComponent } from './real-estate-overview/real-estate-overview.component';
import { RealEstateDetailComponent } from './real-estate-detail/real-estate-detail.component';

export const routes: Routes = [
  { path: 'requests', component: RequestOverviewComponent },
  { path: 'requests/:id', component: RequestOverviewComponent },
  { path: 'real-estates', component: RealEstateOverviewComponent },
  { path: 'real-estates/:id', component: RealEstateDetailComponent },
  { path: '', redirectTo: '/real-estates', pathMatch: 'full' } 
];
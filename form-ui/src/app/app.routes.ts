import { Routes } from '@angular/router';
import { RequestOverviewComponent } from './request-overview/request-overview.component';
import { ItemOverviewComponent } from './item-overview/item-overview.component';

export const routes: Routes = [
  { path: 'request-overview', component: RequestOverviewComponent },
  { path: 'item-overview', component: ItemOverviewComponent },
  { path: '', redirectTo: '/item-overview', pathMatch: 'full' } 
];
import { Component, inject, OnInit, signal } from '@angular/core';
import { DefaultService, RequestOverviewDto } from '../core/modules/openapi';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'request-overview',
  standalone: true,
  templateUrl: './request-overview.component.html',
  providers: [DefaultService],
  imports: [CommonModule]
})
export class RequestOverviewComponent implements OnInit {
  private defaultService: DefaultService = inject(DefaultService);
  requests = signal<RequestOverviewDto[]>([]);

  ngOnInit() {
    this.loadRequests();
  }

  loadRequests() {
    this.defaultService.listRequests().subscribe({
      next: (data) => {
        this.requests.set(data);
        
      },
      error: (error) => console.error('Error fetching requests', error)});
  }

  showDetails(id: string | undefined) {
    if (!id){
      return;
    }
    console.log('Show details for request', id);
  }
}
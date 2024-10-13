import { Component, inject, OnInit, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DefaultService, RealEstateDto, RequestDto } from '../core/modules/openapi';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'request-detail',
  standalone: true,
  templateUrl: './request-detail.component.html',
  providers: [DefaultService],
  imports: [CommonModule]
})
export class RequestDetailComponent implements OnInit {
  private defaultService = inject(DefaultService);
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  requestDetail = signal<RequestDto | null>(null);

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.loadRequestDetail(id);
    }
  }

  loadRequestDetail(id: string) {
    this.defaultService.findRequestById(id).subscribe({
      next: (data) => {
        this.requestDetail.set(data);
      },
      error: (error) => console.error('Error fetching real estate details', error)
    });
  }

  goBack() {
    this.router.navigate(['/requests']);
  }
}

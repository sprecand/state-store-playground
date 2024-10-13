import { Component, inject, OnInit, signal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DefaultService, RealEstateDto } from '../core/modules/openapi';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'real-estate-detail',
  standalone: true,
  templateUrl: './real-estate-detail.component.html',
  providers: [DefaultService],
  imports: [CommonModule]
})
export class RealEstateDetailComponent implements OnInit {
  private defaultService = inject(DefaultService);
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  realEstateDetail = signal<RealEstateDto | null>(null);

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.loadRealEstateDetail(id);
    }
  }

  loadRealEstateDetail(id: string) {
    this.defaultService.findRealEstateById(id).subscribe({
      next: (data) => {
        this.realEstateDetail.set(data);
      },
      error: (error) => console.error('Error fetching real estate details', error)
    });
  }

  goBack() {
    this.router.navigate(['/real-estates']);
  }

  addRequest(id: string | undefined) {
    if (!id){
      return;
    }
    this.router.navigate(['/requests', id]);
  }
}

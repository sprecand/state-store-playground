import { Component, inject, OnInit, signal } from '@angular/core';
import { DefaultService, RealEstateOverviewDto } from '../core/modules/openapi';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'real-estate-overview',
  standalone: true,
  templateUrl: './real-estate-overview.component.html',
  providers: [DefaultService],
  imports: [CommonModule]
})
export class RealEstateOverviewComponent implements OnInit {
  private defaultService: DefaultService = inject(DefaultService);
  private router = inject(Router);
  realEstateList = signal<RealEstateOverviewDto[]>([]);

  ngOnInit() {
    this.loadRealEstateList();
  }

  loadRealEstateList() {
    this.defaultService.findRealEstate().subscribe({
      next: (data) => {
        this.realEstateList.set(data);
      },
      error: (error) => console.error('Error fetching real estate list', error)});
  }

  showDetails(id: string | undefined) {
    if (!id){
      return;
    }
    this.router.navigate(['/real-estates', id]);
  }

  addRequest(id: string | undefined) {
    if (!id){
      return;
    }
    this.router.navigate(['/requests', id]);
  }
}

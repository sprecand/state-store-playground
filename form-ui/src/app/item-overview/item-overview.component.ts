import { Component, inject, OnInit, signal } from '@angular/core';
import { DefaultService, ItemOverviewDto } from '../core/modules/openapi';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'item-overview',
  standalone: true,
  templateUrl: './item-overview.component.html',
  providers: [DefaultService],
  imports: [CommonModule]
})
export class ItemOverviewComponent implements OnInit {
  //private defaultService: DefaultService = inject(DefaultService);
  
  items = signal<ItemOverviewDto[]>([]);

  constructor(private defaultService: DefaultService) {
    console.log('Current basePath:', this.defaultService.configuration.basePath);
  }

  ngOnInit() {
    console.log('About to load items');
    this.loadItems();
  }

  loadItems() {
    this.defaultService.findItems().subscribe({
      next: (data) => {
        console.log('Items loaded:', data);
        this.items.set(data);
        
      },
      error: (error) => {
        console.error('Error fetching items', error)
        if (error.error instanceof ErrorEvent) {
          console.error('Client-side error:', error.error.message);
        } else {
          console.error(`Backend returned code ${error.status}, body was:`, error.error);
        }
      }
    });
  }
}
import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { environment } from '../environments/environment';
import { routes } from './app.routes';
import { HttpClient, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { Configuration, DefaultService } from './core/modules/openapi';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }), 
    provideRouter(routes),
    provideHttpClient(withInterceptorsFromDi()),
    {
      provide: DefaultService,
      useFactory: (httpClient: HttpClient) => {
        const configuration = new Configuration({ basePath: environment.apiBaseUrl });
        return new DefaultService(httpClient, environment.apiBaseUrl, configuration);
      },
      deps: [HttpClient]
    }
  ]
};

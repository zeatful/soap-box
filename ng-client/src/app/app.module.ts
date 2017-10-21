import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NotFoundComponent } from './common/not-found/not-found.component';
import { NavbarComponent } from './navbar/navbar.component';

import { ErrorHandler } from '@angular/core';
import { AppErrorHandler } from './errors/app-error-handler';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    // order mattersin the RouterModule arrays
    RouterModule.forRoot([
      { path: '', component: AppComponent },
      { path: '**', component: NotFoundComponent }// catch any other route and throw an error
    ])
  ],
  providers: [
    // tells angular to use our implementation any where ErrorHandler was used
    { provide: ErrorHandler, useClass: AppErrorHandler }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

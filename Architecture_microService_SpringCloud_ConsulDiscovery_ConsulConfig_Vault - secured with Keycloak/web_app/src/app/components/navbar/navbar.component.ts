import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';
import {Router} from '@angular/router';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router:Router ) { }

  items!: MenuItem[];

    ngOnInit() {
        this.items = [
            {
                label:'Products',
                icon:'pi pi-fw pi-clone',
                items:[
                    {
                        label:'New',
                        icon:'pi pi-fw pi-plus',
                    },
                    {
                        label:'List',
                        icon:'pi pi-fw pi-list',
                        command: (event) => {     this.router.navigate(['products']);
                      }
                    },
                    
                ]
            },
            
            {
                label:'Customers',
                icon:'pi pi-fw pi-user',
                items:[
                    {
                        label:'New',
                        icon:'pi pi-fw pi-user-plus',

                    },
                    {
                        label:'List',
                        icon:'pi pi-fw pi-list',
                        command: (event) => {    this.router.navigate(['customers']);}
                    },
                    {
                        label:'Search',
                        icon:'pi pi-fw pi-users',
                    }
                ]
            },
            {
              label:'Orders',
              icon:'pi pi-fw pi-shopping-cart',
              command: (event) => {    this.router.navigate(['orders']);}
          },
            
        ];
    }
}


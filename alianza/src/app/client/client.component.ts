import { Component, OnInit } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { TableModule } from 'primeng/table';
import { OverlayPanelModule } from 'primeng/overlaypanel';
import { CalendarModule } from 'primeng/calendar';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { DialogModule } from 'primeng/dialog';
import { DividerModule } from 'primeng/divider';
import { ClientService } from '../services/client.service';
import { ClientDTO } from '../shared/Client';
import { Router } from '@angular/router';
import { KeyFilterModule } from 'primeng/keyfilter';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { MessagesModule } from 'primeng/messages';
import { Message } from 'primeng/api';

@Component({
  selector: 'app-client',
  standalone: true,
  imports: [ButtonModule, 
    InputGroupModule, 
    InputGroupAddonModule, 
    TableModule, 
    OverlayPanelModule,
    CalendarModule,
    FormsModule,
    InputTextModule,
    DialogModule,
    DividerModule,
    KeyFilterModule,
    ConfirmPopupModule,
    MessagesModule ],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})

export class ClientComponent implements OnInit{

  constructor(private clientService: ClientService, private router:Router){}

  ngOnInit(): void {
    this.findAll();
  }

  startDate!: Date;
  endDate!: Date;
  name!: string;
  email!: string;
  phone!: string;
  clients!: any;
  sharedKey!: string;

  visible: boolean = false;
  messages!: Message[];

  showDialog() {
    this.visible = true;
  }

  findAll(){
    this.clientService.findAll().subscribe(response => {
      this.clients = response;
    });
  }

  save(){
    let client = new ClientDTO("", this.name, this.phone, this.email, new Date());
    let valid = this.validateFields(this.email, this.phone, this.name);
    if(valid){
      this.clientService.save(client).subscribe(response => {
        this.visible = false;
        this.findAll();
        this.clear();
      });
    }
  }

  findBySharedKey(){
    this.clientService.findBySharedKey(this.sharedKey).subscribe(response => {
      const clients: any[] = []
      clients.push(response);
      this.clients = clients;
    });
  }

  validateFields(email:string, phone:string, name:string) : boolean{
    let regexEmail = new RegExp("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}");
    let regexPhone = new RegExp("^\d{10}$");
    let warns: any[] = [];
    if(name == "" || name == undefined){
      warns.push({ severity: 'warn', summary: 'warning', detail: "Name cannot be empty." });
    }
    if(!regexEmail.test(email) || email == ""){
      warns.push({ severity: 'warn', summary: 'warning', detail: "Email doesn't contain a valid format." });
    }
    if(!regexPhone.test(phone)){
      warns.push({ severity: 'warn', summary: 'warning', detail: "Phone must contain 10 numbers" });
    }
    if(warns.length == 0){
      return true;
    } else {
      this.messages = warns;
      return false;
    }
  }

  clear(): void{
    this.name = "";
    this.email = "";
    this.phone = "";
  }
}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminview',
  templateUrl: './adminview.component.html',
  styleUrls: ['./adminview.component.css']
})
export class AdminviewComponent implements OnInit {
  bids: any
  bid: any

  constructor() { }

  ngOnInit(): void {
  }
  delete(bid: any) {

  }
}

import {BorderCardDirective} from './border-card.directive';
import {ElementRef} from "@angular/core";

describe('BorderCardDirective', () => {
  it('should create an instance', () => {
    const el = new ElementRef(null);
    const directive = new BorderCardDirective(el);
    expect(directive).toBeTruthy();
  });
});

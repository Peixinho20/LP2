#include <stdio.h>
#include <stdlib.h>
#include "rect.h"


typedef struct Rect {
	int x, y;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n", this->w, this->h, this->x, this->y);
}

void rect_drag(Rect* this, int dx, int dy){
	this->x += dx;
	this->y += dy;
}

Rect* rect_new (void) {
    Rect*   this  = malloc(sizeof(Rect));
    int x = 0;
    int y = 0;
    int w = 20;
    int h = 10;

    this->x = x;
    this->y = y;
    this->w = w;
    this->h = h;
    
    return this;
}

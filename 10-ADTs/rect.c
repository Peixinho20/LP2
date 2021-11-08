#include <stdio.h>
#include <stdlib.h>


typedef struct {
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

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    this->x = x;
    this->y = y;
    this->w = w;
    this->h = h;
}

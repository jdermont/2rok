#include <stdio.h>

void main()
{
	float a,b,c;
	float x1,delta;
	float x2 = -1;
	printf("Podaj wspolczynnik a: ");
	scanf("%f",&a);
	printf("Podaj wspolczynnik b: ");
	scanf("%f",&b);
	printf("Podaj wspolczynnik c: ");
	scanf("%f",&c);

	if (a == 0) {
		if (b == 0 && c == 0) {
		  printf("Rownanie ma nieskonczenie wiele rozwiazan.\n");
		} else if (b == 0 && c != 0) {
		  printf("Rownanie jest sprzeczne.\n");
		} else if (b != 0 && c == 0) {
		  printf("x = 0");
		} else {
			_asm {
				finit
				fld c
				fld b
				fdiv
				fstp x1
			}
			_asm {
				finit
				fld x1
				fld x2
				fmul
				fstp x1
			}
			printf("x = %f\n",x1);
		}
	} else {
		if (b == 0) {
			if (c == 0) {
			  printf("x1 = x2 = 0.\n");
			}
			else if (a*c > 0) {
			  printf("Rownanie jest sprzeczne.\n");
			} else {
				if (c < 0) {
					_asm {
						finit
						fld c
						fld x2
						fmul
						fstp c
					}
				}
				_asm {
					finit
					fld c
					fld a
					fdiv
					fstp c
				}
				_asm {
					finit
					fld c
					fsqrt
					fstp x1
				}
				_asm {
					finit
					fld x1
					fld x2
					fmul
					fstp x2
				}
				printf("x1 = %f, x2 = %f.\n",x1,x2);
			}
		} else {
			if (c == 0) {
				x1 = 0;
				_asm {
					finit
					fld b
					fld a
					fdiv
					fstp b
				}
				_asm {
					finit
					fld b
					fld x2
					fmul
					fstp x2
				}
				printf("x1 = %f, x2 = %f.\n",x1,x2);
			} else {
				delta = 4;
				_asm {
					finit
					fld b
					fld b
					fmul
					fld delta
					fld a
					fmul
					fld c
					fmul
					fsub
					fstp delta
				}
				if (delta < 0) {
				  printf("Rownanie jest sprzeczne.\n",x1,x2);
				}
				else if (delta == 0) {
					_asm {
						finit
						fld b
						fld a
						fld a
						fadd
						fdiv
						fstp x1
					}
					_asm {
						finit
						fld x1
						fld x2
						fmul
						fstp x1
					}
					printf("x1 = x2 = %f\n",x1);
				} else {
					_asm {
						finit
						fld b
						fld x2
						fmul
						fstp b
					}
					_asm {
						finit
						fld b
						fld delta
						fsqrt
						fadd
						fld a
						fld a
						fadd
						fdiv
						fstp x1
					}
					_asm {
						finit
						fld b
						fld delta
						fsqrt
						fsub
						fld a
						fld a
						fadd
						fdiv
						fstp x2
					}
					printf("x1 = %f, x2 = %f.\n",x1,x2);
				}
			}
		}
	}

	getchar(); //pauza
}



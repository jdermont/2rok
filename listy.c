#include <stdio.h>
#include <stdlib.h>

struct SList {
	struct SList *prev;
	int wartosc;
	struct SList *next;
};

struct SList *lista = NULL;

void addBegin(int i) {
	struct SList *nowy = (struct SList *)malloc(sizeof(struct SList));
	nowy->wartosc = i;
	if (lista == NULL) {
        lista = nowy;
	} else {
		nowy->next = lista;
        nowy->prev = nowy;
        lista = nowy;
	}
}

void addMiddle(int s,int i) {
   	struct SList *temp = lista;
    int a = 0;
    while (temp != NULL) {
        if (temp->wartosc == s) {
            struct SList *nowy = (struct SList *)malloc(sizeof(struct SList));
            nowy->wartosc = i;
            nowy->next = temp->next;
            nowy->prev = temp;
            temp->next = nowy;
            
			a = 1;
			return;
		}
		temp = temp->next;
	}
	if (a == 0) printf("65465465Nie wstawiono nowego elementu %i, bo nie ma wskazanego elementu: %i.\n",i,s);
}

void search(int i) {
	struct SList *temp = lista;

    while(temp != NULL) {
		if (temp->wartosc == i) {
			printf("Znaleziono %i na liscie.\n",i);
			return ;
		}
		temp = temp->next;
	}
	printf("Nie znaleziono %i na liscie.\n",i);
}

void print() {
    struct SList *nowy;
    for (nowy=lista;nowy!=NULL;nowy=nowy->next) {
        printf("%i ",nowy->wartosc);
    }
    printf("\n\n");
}

int main() {
    printf("PIERWSZA LISTA:\n");
    addBegin(1);
    addBegin(2);
    addBegin(3);
    addBegin(4);

    search(2);
    search(5);
    print();

    lista = NULL;

    printf("DRUGA LISTA:\n");
    addBegin(1);
    addBegin(2);
    addBegin(3);
    addBegin(4);
    addMiddle(2,9);
    addMiddle(5,6);

    search(3);
    print();

	free(lista);


	return 0;
}

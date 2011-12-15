.model small
.386           ; aby korzystac z rejestru 32 bitowego

.code
  ORG 100h     ; to bedzie program typu .com

tablica db 0,0,0,0,0,0,0,0
zmienna db 0
stala db 0

start:
    	mov ds,ax
	mov bx,2
	mov eax,121
	mov [zmienna],al
	mov [stala],al
	mov dh,2
	mov bx,0
	call dwojkowy
	call osemkowy
	call dziesietny 
        ;zakonczenie wykonywania programu nastepuje po nacisnieciu dowolnego klawisza
        mov ah, 1
        int 21H
	;te dwie linijki uruchamiaja procedure zakonczenia programu
        mov ax, 4C00H     
        int 21H

printuj proc
	print:
		mov al,[tablica+bx]
		dec bx
		mov ah,0EH
		int 10H
		mov al,dl
		loop print
	ret
printuj endp

dwojkowy proc
	dwojkowe:
		mov ah,0
		div dh
		mov [zmienna],al
		mov al,ah
		add al,30H
		mov [tablica+bx],al
		inc bx
		mov al,[zmienna]
		cmp al,0
		jna skocz1
		jmp dwojkowe
	skocz1:
	mov cx,bx
	dec bx
	call printuj
	mov al,62H
	mov ah,0EH
	int 10H
	mov al,20H
	int 10H
	mov al,[stala]
	mov [zmienna],al
	mov dh,8
	mov bx,0
	ret
dwojkowy endp

osemkowy proc
	osemkowe:
		mov ah,0
		div dh
		mov [zmienna],al
		mov al,ah
		add al,30H
		mov [tablica+bx],al
		inc bx
		mov al,[zmienna]
		cmp al,0
		jna skocz2
		jmp osemkowe
	skocz2:
	mov cx,bx
	dec bx
	call printuj
	mov al,6FH
	mov ah,0EH
	int 10H
	mov al,20H
	int 10H
	mov al,[stala]
	mov [zmienna],al
	mov dh,10
	mov bx,0
	ret
osemkowy endp

dziesietny proc
	dziesietne:
		mov ah,0
		div dh
		mov [zmienna],al
		mov al,ah
		add al,30H
		mov [tablica+bx],al
		inc bx
		mov al,[zmienna]
		cmp al,0
		jna skocz3
		jmp dziesietne
	skocz3:
	mov cx,bx
	dec bx
	call printuj
	mov al,64H
	mov ah,0EH
	int 10H
	ret
dziesietny endp

kod ends
end start

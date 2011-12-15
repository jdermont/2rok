dane segment
dane ends

kod  segment
        assume cs:kod, ds: dane

tab db 0,0,0,0,0,0,0,0
pomoc db 0
inna db 0

start:
	mov ax, seg dane
    	mov ds,ax
	mov al,59
	mov [pomoc],al
	mov [inna],al
	mov dh,2
	mov bx,0
	liczbybinarne:
		mov ah,0
		div dh
		mov [pomoc],al
		mov al,ah
		add al,30H
		mov [tab+bx],al
		inc bx
		mov al,[pomoc]
		cmp al,0
		jna mniejsze1
		jmp liczbybinarne
	mniejsze1:
	mov cx,bx
	sub bx,1
	wydrukuj1:
		mov al,[tab+bx]
		dec bx
		mov ah,0EH
		int 10H
		mov al,dl
		loop wydrukuj1
	mov al,62H
	mov ah,0EH

	int 10H
	mov al,20H
	int 10H

	mov al,[inna]
	mov [pomoc],al
	mov dh,8
	mov bx,0
	liczbyosemkowe:
		mov ah,0
		div dh
		mov [pomoc],al
		mov al,ah
		add al,30H
		mov [tab+bx],al
		inc bx
		mov al,[pomoc]
		cmp al,0
		jna mniejsze2
		jmp liczbyosemkowe
	mniejsze2:
	mov cx,bx
	sub bx,1
	wydrukuj2:
		mov al,[tab+bx]
		dec bx
		mov ah,0EH
		int 10H
		mov al,dl
		loop wydrukuj2
	mov al,6FH
	mov ah,0EH

	int 10H
	mov al,20H
	int 10H

	mov al,[inna]
	mov [pomoc],al
	mov dh,10
	mov bx,0
	liczbydziesietne:
		mov ah,0
		div dh
		mov [pomoc],al
		mov al,ah
		add al,30H
		mov [tab+bx],al
		inc bx
		mov al,[pomoc]
		cmp al,0
		jna mniejsze3
		jmp liczbydziesietne
	mniejsze3:
	mov cx,bx
	sub bx,1
	wydrukuj3:
		mov al,[tab+bx]
		dec bx
		mov ah,0EH
		int 10H
		mov al,dl
		loop wydrukuj3
	mov al,64H
	mov ah,0EH

	int 10H
	mov al,20H
	int 10H

        ;zakonczenie wykonywania programu nastepuje po nacisnieciu dowolnego klawisza
        mov ah, 1
        int 21H
	;te dwie linijki uruchamiaja procedure zakonczenia programu
        mov ax, 4C00H     
        int 21H
kod ends

end start

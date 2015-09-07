    lw	$1,x
    sll $2,$1,7
    sw  $2,y
    halt
x:  .word 0x12345678
y:  .word 0			# should become 0x1a2b3c00

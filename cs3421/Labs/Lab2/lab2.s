# Jeremy Sommerfeld
#
# CS3421 Lab 2
# Spring 2015
#
        .text
        li	$t0, 0 		# counter set at $t0
        lw	$t1, lsize 	# loads the size of the array into $t1
        sll	$t1, $t1, 2	# Multiply size by 4 to get correct bit-size
	
greaterloop:
	lw	$a0, lstart($t0)	# Load value at counter into register
	ble	$a0, 100, greaterelse	# Check if value is greater than 100
	
# then part (If value is greater than 100)
	sra	$t0, $t0, 2	# Divede size back by 4 to set size to decimal
	sw	$t0, lsize 	# Save new shortened size to lsize
	b	greaterdone	# Branch to end of loop
	
# else part
greaterelse:
	addi	$t0, $t0, 4		# Increment array counter
	beq	$t0, $t1, greaterdone	# Check if we are at the end of the array
	b	greaterloop		# Re-Start Loop
	
greaterdone:
	li	$t0, 0		# reset counter
	li	$t1, 4		# Next value counter
	lw	$t2, lsize	# reset size
	sll	$t2, $t2, 2	# Multiply size by 4 to get correct bit-size
	
dupouter:
	lw	$t2, lsize	# reset size
	sll	$t2, $t2, 2	# Multiply size by 4 to get correct bit-size
	beq	$t0, $t2 dupdone	# If we reach the end, goto dupdone
	lw	$a0, lstart($t0)	# Current value
	lw	$a1, lstart($t1)	# Next value
	
	# Body of loop
dupif:
	bne	$a0, $a1, dupelse
	move	$t3, $t0
	addi	$t4, $t3, 4
	
# Then Part - Shift loop
dupinner:
	beq	$t3, $t2, dupinnerdone	# Check if we reach inner loop end
	lw	$a2, lstart($t4)	# Load next into register
	sw	$a2, lstart($t3)	# Save next to cur
	addi	$t3, $t3, 4	# Increment Counter
	addi	$t4, $t4, 4	# Increment next counter
	b	dupinner
	
dupinnerdone:
	lw	$t5, lsize	# Load in lsize
	addi	$t5, $t5, -1	# Decrement lsize
	sw	$t5, lsize	# Store new value of size
	b	dupouter

dupelse:
	addi	$t0, $t0, 4	# increment counters
	addi	$t1, $t1, 4	# increment counters
	b 	dupouter	# Head back to start of loop

duparound:

	# End of body of loop
dupdone:

# endcode
# DO NOT EDIT BELOW THIS LINE - ALL CODE BELOW THIS LINE WILL BE
# DISCARDED AND REPLACED DURING TESTING
# the code below prints the array values and terminates execution
	.text
	li	$t0, 0
	lw	$t1, lsize
	sll	$t1, $t1, 2 
prloop:
	lw	$a0, lstart($t0)
# Prints number and then space
	li	$v0,1
	syscall
	la	$a0,space
	li	$v0,4
	syscall
	addi	$t0, $t0, 4
# Exits loop
	beq	$t0,$t1,prdone
	b	prloop
# Exits program
prdone:
	la	$a0, eol
	li	$v0, 4
	syscall
	li	$v0,10
	syscall
	.data
space:	.asciiz	" "
eol:	.asciiz "\n"

# here's the pointer list
lsize:	.word	10
lstart: .word	-22
	.word	34
	.word	34
	.word   34
	.word	47
	.word	89
	.word	89
	.word	98
	.word	186
	.word	255
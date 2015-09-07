# Jeremy Sommerfeld
#
# CS3421 Lab 3
# Spring 2015
#
# GCD function
#
    .text
# test program starts here
    li    $v0,-17         	# just to avoid a common mistake    
    li    $s0,-17         	# just to avoid a common mistake
    li    $s1,-17         	# just to avoid a common mistake
    li    $s2,-17         	# just to avoid a common mistake
    li    $s3,-17         	# just to avoid a common mistake
    li    $s4,-17         	# just to avoid a common mistake
    li    $s5,-17         	# just to avoid a common mistake
    li    $s6,-17         	# just to avoid a common mistake
    li    $s7,-17         	# just to avoid a common mistake
    li    $a0,27       	# Argument to the gcd function
    li    $a1,9      	# Argument to the gcd function
    
    jal   gcd      	  	# call the function

    addi    $a0,$v0,0
    li    $v0,1
    syscall
    la    $a0,space       	# print a space
    li    $v0,4
    syscall
    la    $a0,newline     	# print a new line
    li    $v0,4
    syscall
    li    $v0,10         	 # exit
    syscall
    .data
# for debug printing
space:
    .asciiz  " "
newline:
    .asciiz  "\n"

# your gcd function starts here:
# DO NOT change the name of the function

# DO NOT MAKE ANY REFERENCES TO LABELS DEFINED ABOVE
# $a0, $a1 = arguments to find the GCD of
    .text
gcd:
	# Save variables on the runtime stack
	addi	$sp, $sp, -12
	sw	$s0, 0($sp)
	sw	$s1, 4($sp)
	sw	$ra, 8($sp)
	
	# Check for negative values
	blt	$a0, $zero, negative
	blt	$a1, $zero, negative
	
	# If y != 0, then goto notZero
	bne	$a1, $zero, notZero
	
	# If y == 0, Return x
	move	$v0, $a0
	b	endGCD
	
negative:
	# If the value is negative, set $v0 to -1 and return
	li	$v0, -1
	b	endGCD
	
notZero:
	# Call GCD( y, (remainder x/y)
	move	$s0, $a0	# Save $a0 for after the call
	move	$s1, $a1	# Save $a1 for after the call
	
	move	$a0, $a1	# Put y into x for next call
	rem	$a1, $s0, $s1	# Find the remainder of x/y
	jal	gcd		# Call gcd again

endGCD:
	# Restore the variables on the runtime stack
	lw	$s0, 0($sp)
	lw	$s1, 4($sp)
	lw	$ra, 8($sp)
	addi	$sp, $sp, 12
	
	# Return
	jr	$ra

myloop:
    load zero       # Set $A to 0
    addi $H $A 0    # Make $H 0 for later use
    addi $B $A 0    # Make sure loads and stores have 0 offsets
    load count      # RA = count
    addi $D $A 0    # RD = RA
    load sum        # RA = sum
    add $A $A $C    # RA = count + sum    
    store sum       # sum = count + sum
    load count      # RA = count
    addi $D $H 1    # RD = 1
    add $A $A $D    # RA = RA + 1
    store count     # count = count + 1    
    sll $E $A $H    # RE = count
    load limit      # RA = limit
    sub $C $A $E        
    bifcnz myloop   # loop if count < limit
    halt

zero:  .word 0
limit: .word 11
count: .word 0
sum:   .word 0      # Should be 55 when done (0x37)


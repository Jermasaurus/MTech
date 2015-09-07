#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <stdint.h>
#include <unistd.h>
#include <stdio.h>

#define S_MEMSIZE 4096

uint16_t mem_org[S_MEMSIZE];
uint16_t mem_chg[S_MEMSIZE];
uint16_t regs[8];
uint16_t PC;

void trace() {
    int i;

    printf("Reg A: %04x\n", regs[0]);
    printf("Reg B: %04x\n", regs[1]);
    printf("Reg C: %04x\n", regs[2]);
    printf("Reg D: %04x\n", regs[3]);
    printf("Reg E: %04x\n", regs[0]);
    printf("Reg F: %04x\n", regs[1]);
    printf("Reg G: %04x\n", regs[2]);
    printf("Reg H: %04x\n", regs[3]);
    printf("PC: %04x\n", PC);

    printf("Different memory locations:\n");

    for (i = 0; i < S_MEMSIZE; i++) {
        if (mem_org[i] != mem_chg[i]) {
            printf("Addr: %03x Old Val: %04x New Val: %04x\n", i, mem_org[i], mem_chg[i]);
        }
    }
}

int main (int argc, char** argv) {
    int mem_fd;
    uint16_t singleword;
    int16_t a, b;
    char word[5];
    char beep;

    int i;

    int readval;

    uint16_t inst = 0;
    uint16_t opcode = 0;
    uint16_t r1 = 0;
    uint16_t r2 = 0;
    uint16_t r3 = 0;
    uint16_t mimm = 0;
    uint16_t kimm = 0;
    uint16_t limm = 0;
    uint16_t leave = 0;

    for (i = 0; i < S_MEMSIZE; i++) {
        mem_org[i] = 0;
        mem_chg[i] = 0;
    }
    for (i = 0; i < 8; i++) {
        regs[i] = 0;
    }

    mem_fd = open("memfile", O_RDONLY);

    if (mem_fd < 0) {
        printf("Error opening memfile!\n");
        exit(2);
    }
    /* Read from file into memory */
    readval = 1;
    i = 0;
    do {
        readval = read(mem_fd, word, 4);
        readval = read(mem_fd, word, 4);
        readval = read(mem_fd, &beep, 1);
        word[4] = 0;
        singleword = (uint16_t)strtol(word, NULL, 16);
        mem_org[i] = singleword;
        mem_chg[i] = singleword;
        i++;

        readval = read(mem_fd, &beep, 1);
        lseek(mem_fd, -1, SEEK_CUR);
    } while(readval > 0);    
  
    close(mem_fd);

    PC = 0;
    inst = 0;
    opcode = 0;
    r1 = 0;
    r2 = 0;
    r3 = 0;
    mimm = 0;
    kimm = 0;
    limm = 0;
    leave = 0;
    while (leave == 0) {
        inst = mem_chg[PC];
        opcode = (inst >> 12) & 0xf;
        r1 = (inst >> 9) & 0x7;
        r2 = (inst >> 6) & 0x7;
        r3 = (inst >> 3) & 0x7;
        mimm = inst & 0x7;
        kimm = inst & 0x3f;
        limm = inst & 0xfff;
        PC++;

        // printf("inst  =0x%08x\n", inst);
        // printf("opcode=%d\n", opcode);
        // printf("r1    =%d\n", r1);
        // printf("r2    =%d\n", r2);
        // printf("ximm  =0x%08x\n", ximm);
        // printf("yimm  =0x%08x\n", yimm);
        // printf("PC    =%d\n\n", PC);

        switch(opcode) {
            case 0: // ADD
                regs[r1] = regs[r2] + regs[r3];
                break;
            case 1: // SUB
                regs[r1] = regs[r2] - regs[r3];
                break;
            case 2: // AND
                regs[r1] = regs[r2] & regs[r3];
                break;
            case 3: // OR
                regs[r1] = regs[r2] | regs[r3];
                break;
            case 4: // NOR
                regs[r1] = ~(regs[r2] | regs[r3]);
                break;
            case 5: // ADDI
                if (kimm & 32)
                    kimm |= 0xffc0;
                regs[r1] = regs[r2] + kimm;
                break;
            case 6: // SLL
                regs[r1] = regs[r2] << regs[r3];
                break;
            case 7: // SRL
                regs[r1] = regs[r2] >> regs[r3];
                break;
            case 8: // LOAD
                if (limm & 2048)
                    limm |= 0xf000;
                limm = regs[1] + limm;
                if (limm >= S_MEMSIZE) {
                    printf("Memory access out of bounds (load).\n");
                    trace();
                    exit(1);
                }
                regs[0] = mem_chg[limm]; 
                break;
            case 9: // STORE
                if (limm & 2048)
                    limm |= 0xf000;
                limm = regs[1] + limm;
                if (limm >= S_MEMSIZE) {
                    printf("Memory access out of bounds (store).\n");
                    trace();
                    exit(1);
                }
                mem_chg[limm] = regs[0];
                break;
            case 10: // LOOP 
                a = regs[2];
                regs[2] = a - 1;
                a = a - 1;
                if (a == 0) {
                    PC = limm;
                } 
                break;
            case 11: // BIFDZ
                if (limm & 2048)
                    limm |= 0xf000;
                if (regs[2] == 0) {
                    PC = PC + limm; 
                }
                break; 
            case 12: // BIFDNZ
                if (limm & 2048)
                    limm |= 0xf000;
                if (regs[2] != 0) {
                    PC = PC + limm; 
                }
                break;
            case 13: // CALL
                regs[3] = PC;
                PC = limm;
                break;
            case 14: // RET
                PC = regs[3];
                break;
            case 15: // HALT OR TRACE
                if (mimm == 0) {
                    leave = 1;
                }
                else {
                    trace();
                }
                break;
        }
    }    
    trace();
}

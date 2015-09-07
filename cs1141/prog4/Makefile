.SUFFIXES: .c .o
CC = gcc
EXEC = radix
CCFLAGS = -ansi -pedantic -g -Wall
OBJS = radix.o funcs.o

${EXEC}: ${OBJS}
	${CC} ${CCFLAGS} -o ${EXEC} ${OBJS}

.c.o:
	${CC} ${CCFLAGS} -c $<

run: ${EXEC}
	./${EXEC}
    
clean:
	rm -f ${EXEC} ${OBJS}

radix.o: radix.c funcs.h
funcs.o: funcs.c funcs.h
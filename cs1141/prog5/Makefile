.SUFFIXES: .c .o
CC = gcc
EXEC = caesar
CCFLAGS = -ansi -pedantic -g -Wall
OBJS = caesar_driver.o caesar.o

${EXEC}: ${OBJS}
	${CC} ${CCFLAGS} -o ${EXEC} ${OBJS}

.c.o:
	${CC} ${CCFLAGS} -c $<

run: ${EXEC}
	./${EXEC}
    
clean:
	rm -f ${EXEC} ${OBJS}

caesar_driver.o: caesar_driver.c caesar.h
caesar.o: caesar.c caesar.h
